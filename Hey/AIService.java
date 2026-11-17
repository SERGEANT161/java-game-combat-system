package fightingGame21;
import java.util.*;
import java.net.URI;
import java.net.http.*;
import com.google.gson.*;
public class AIService {
	public static void chat(GameTime time,Player user,NPC npc,String npcAction,String userInput) throws Exception{
		Gson gson=new Gson();
		String responseFormat1="""
				{
                   "type": "json_schema",
                   "json_schema": {
                       "name": "npc_dialogue",
                       "schema": {
                           "type": "object",
                           "properties": {
                               "dialogue": {
                                   "type": "string"
                               }
                               },
                           "required": ["dialogue"],
                           "additionalProperties": false
                       },
                       "strict": true
                      }
                 }
				""";
		String responseFormat2="""
				{
				    "type":"json_schema",
				    "json_schema": {
				        "name":"npc_response",
				        "schema": {
				            "type":"object",
				            "properties": {
				                "trust": {
				                    "type":"string",
				                    "enum":["MAX", "MIN", "NONE", "-MIN", "-MAX"]
				                },
				                "respect": {
                                    "type": "string",
                                    "enum": ["MAX", "MIN", "NONE", "-MIN", "-MAX"]
                                },
                                "attachment": {
                                    "type": "string",
                                    "enum": ["MAX", "MIN", "NONE", "-MIN", "-MAX"]
                                },
                                    "loyalty": {
                                    "type": "string",
                                    "enum": ["MAX", "MIN", "NONE", "-MIN", "-MAX"]
                                },
                                "fatigue": {
                                    "type": "string",
                                    "enum": ["MAX", "MIN", "NONE", "-MIN", "-MAX"]
                                },
                                "mood": {
                                    "type": "string",
                                    "enum": ["MAX", "MIN", "NONE", "-MIN", "-MAX"]
                                },
                                "reason": {
                                    "type": "string"
                                }
                                },
                            "required": [
                              "trust",
                              "respect",
                              "attachment",
                              "loyalty",
                              "fatigue",
                              "mood",
                              "reason"
                            ],
				            "additionalProperties":false
				        },
				        "strict":true
				    }
				}
				""";
		String currentStatus = """
			    time:%s
			    action:%s
			    trust:%d
			    respect:%d
			    attachment:%d
			    loyalty:%d
			    fatigue:%d
			    mood:%d
			    """.formatted(
			        time.getTime(),
			        npcAction,
			        npc.getTrust(),
			        npc.getRespect(),
			        npc.getAttachment(),
			        npc.getLoyalty(),
			        npc.getFatigue(),
			        npc.getMood()
			    );
		String dialogueRule="""
				Describe actions in third-person present tense (He), and speak in first person (I), using quotation marks.
                React naturally to the player's input and current activity without unnecessary narration or invented events.
                The dialogue field must contain the NPC's own action and spoken reply, not the player's words.
				Generate the NPC's response to the player.
                The dialogue field must contain one brief action in third person and one spoken sentence in first person.
                Do not repeat the player's words.
                """;
        String evaluateRule="""
                Evaluate how the player's words and actions affect the NPC's stats.
                All stats represent the NPC's state or attitude toward the player.

                trust: Confidence in the player's reliability and honesty.
                respect: Recognition of the player's character and actions.
                attachment: Emotional closeness and affection toward the player.
                loyalty: Willingness to support and stand by the player.
                fatigue: Physical and mental exhaustion.
                mood: Temporary emotional state.

                For each stat, choose MAX, MIN, NONE, -MIN, or -MAX.
                MAX: Major increase.
                MIN: Minor increase.
                NONE: No change.
                -MIN: Minor decrease.
                -MAX: Major decrease.

                Evaluate the actual meaning and impact of each interaction.
                Genuine kindness, affection, care, and support can increase relevant stats, even through simple conversations.
                Hostility, insults, threats, betrayal, and harmful actions can decrease relevant stats.

                Use MIN or -MIN for ordinary positive or negative interactions.
                Reserve MAX or -MAX for strongly impactful interactions.
                Use NONE for neutral or unrelated effects.

                Do not change every stat automatically.
                Lack of a positive effect does not mean a negative effect.
                Words can affect emotions and relationships, but an offer or promise is not the same as a completed action.
                Fatigue changes only when exhaustion is actually affected.

                Base judgments on the player's behavior, not the NPC's outward response. Keep the reason brief.
				""";
		String systemPrompt1=npc.getCharacterProfile()+"\n\n"+currentStatus+"\n\n"+dialogueRule;
		String profileJson1=gson.toJson(systemPrompt1);
		String systemPrompt2=evaluateRule;
		String profileJson2=gson.toJson(systemPrompt2);
		System.out.println("");
		String inputJson=gson.toJson(userInput);
	    HttpClient client=HttpClient.newHttpClient();
	    String json1="""
	           {
	               "model":"gemma-3-12b-it-qat",

	               "messages":[
	                   {
	                       "role":"system",
	                       "content":%s
	                   },
	                   {
	                       "role":"user",
	                       "content":%s
	                   }
	               ],
	               "max_tokens": 200,
	               "temperature":0.8,
	               "response_format":%s
	           }
	           """.formatted(profileJson1,inputJson,responseFormat1);
	   USB(json1,npc,false);
        String json2="""
 	           {
 	               "model":"gemma-3-12b-it-qat",

 	               "messages":[
 	                   {
 	                       "role":"system",
 	                       "content":%s
 	                   },
 	                   {
 	                       "role":"user",
 	                       "content":%s
 	                   }
 	               ],
 	               "max_tokens": 200,
 	               "temperature":0.8,
 	               "response_format":%s
 	           }
 	           """.formatted(profileJson2,inputJson,responseFormat2);
 	   USB(json2,npc,true);
 	   time.addTime();
 	   Check.checkTime(time, npc);
 	   Plot.camp(time,user,npc);
	   }
	
	private static void USB(String json,NPC npc,boolean way) throws Exception{
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder()
			 	   .uri(URI.create("http://localhost:1234/v1/chat/completions"))
			 	   .header("Content-Type", "application/json")
			 	   .POST(HttpRequest.BodyPublishers.ofString(json))
			    	   .build();
			 	    HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
		JsonObject root=JsonParser.parseString(response.body()).getAsJsonObject();
		String content = root.getAsJsonArray("choices")
    	        .get(0).getAsJsonObject()
    	        .getAsJsonObject("message")
    	        .get("content").getAsString();
    	JsonObject result=JsonParser.parseString(content).getAsJsonObject();
	    if(way==false) {
	    	String dialogue=result.get("dialogue").getAsString();
	    	System.out.println(dialogue.replaceFirst("\\s*\"", "\n\""));
	    }else {
	    	String trust=result.get("trust").getAsString();
	    	String respect=result.get("respect").getAsString();
	    	String attachment=result.get("attachment").getAsString();
	    	String loyalty=result.get("loyalty").getAsString();
	    	String mood=result.get("mood").getAsString();
	    	String fatigue=result.get("fatigue").getAsString();
	    	switch(trust) {
	    	case "MAX":npc.gainTrustMax();break;
	        case "MIN":npc.gainTrustMin();break;
	        case "NONE":break;
	        case "-MIN":npc.loseTrustMin();break;
	        case "-MAX":npc.loseTrustMax();break;
	    	}
	    	switch(respect) {
	    	case "MAX":npc.gainRespectMax();break;
	        case "MIN":npc.gainRespectMin();break;
	        case "NONE":break;
	        case "-MIN":npc.loseRespectMin();break;
	        case "-MAX":npc.loseRespectMax();break;
	    	}
	    	switch(attachment) {
	    	case "MAX":npc.gainAttachmentMax();break;
	        case "MIN":npc.gainAttachmentMin();break;
	        case "NONE":break;
	        case "-MIN":npc.loseAttachmentMin();break;
	        case "-MAX":npc.loseAttachmentMax();break;
	    	}
	    	switch(loyalty) {
	    	case "MAX":npc.gainLoyaltyMax();break;
	        case "MIN":npc.gainLoyaltyMin();break;
	        case "NONE":break;
	        case "-MIN":npc.loseLoyaltyMin();break;
	        case "-MAX":npc.loseLoyaltyMax();break;
	    	}
	    	switch(fatigue) {
	    	case "MAX":npc.gainFatigueMax();break;
	        case "MIN":npc.gainFatigueMin();break;
	        case "NONE":break;
	        case "-MIN":npc.loseFatigueMin();break;
	        case "-MAX":npc.loseFatigueMax();break;
	    	}
	    	switch(mood) {
	    	case "MAX":npc.gainMoodMax();break;
	        case "MIN":npc.gainMoodMin();break;
	        case "NONE":break;
	        case "-MIN":npc.loseMoodMin();break;
	        case "-MAX":npc.loseMoodMax();break;
	    	}
	    	System.out.println("");
	    	System.out.println("trust: "+npc.getTrust()+"("+trust+")");
	    	System.out.println("respect: "+npc.getRespect()+"("+respect+")");
	    	System.out.println("attachment: "+npc.getAttachment()+"("+attachment+")");
	    	System.out.println("loyalty: "+npc.getLoyalty()+"("+loyalty+")");
	    	System.out.println("fatigue: "+npc.getFatigue()+"("+fatigue+")");
	    	System.out.println("mood: "+npc.getMood()+"("+mood+")");
	    }
	}
	
}
