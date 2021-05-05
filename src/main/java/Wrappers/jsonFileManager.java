package Wrappers;
import com.google.gson.JsonObject;
import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;


public class jsonFileManager {
public static String JsonFile="Test.json";
//JsonObject JsonObject;
public JSONObject JsonObject;
String FileName;
public jsonFileManager(String file)
{
    //parseJson(file);
   // jsonReader();
    FileName=file;

}
/*public String getDataFile(String FileName)  {
    String result=null;
  try{
      BufferedReader br=new BufferedReader(new FileReader(FileName));
      StringBuilder sb=new StringBuilder();
      String line= br.readLine();
      while (line!=null)
      {
          sb.append(line);
          line= br.readLine();
      }
       result=sb.toString();
      //System.out.println(result);
      return result;
  }
  catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
  }
  catch (IOException e) {
      e.printStackTrace();
      return null;
  }


}
 public void parseJson(String File)
 {
     String JsonData =getDataFile(File);
     try{
         JsonObject=new JSONObject(JsonData);
     }
     catch (Exception e)
     {
        e.printStackTrace();
     }
 }
 public String getValueOfNode(String Node)
 {
     return JsonObject.getString(Node);
 }*/
 public String[] jsonReader()  {
     JSONParser JsonParser=new JSONParser();
     FileReader reader= null;
     try {
         reader = new FileReader(FileName);
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     }
     Object Obj= null;
     try {
         Obj = JsonParser.parse(reader);
     } catch (IOException e) {
         e.printStackTrace();
     } catch (ParseException e) {
         e.printStackTrace();
     }
     org.json.simple.JSONObject Obj2 = (org.json.simple.JSONObject) Obj;
     org.json.simple.JSONArray  ObjArray= (org.json.simple.JSONArray) Obj2.get("Data");
     String arr[]= new String[ObjArray.size()];
     for (int i=0;i<ObjArray.size();i++)
     {
         org.json.simple.JSONObject Obj3= (org.json.simple.JSONObject) ObjArray.get(i);
         String send_button=(String) Obj3.get("send_document_button");
         String header_title=(String) Obj3.get("header_title_path");
         arr[i]=send_button+","+header_title;
         //System.out.println(arr[i]);
     }
     return arr;
 }
}
