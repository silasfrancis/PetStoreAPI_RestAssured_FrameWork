package api.payload;

import com.github.javafaker.Faker;
import org.json.JSONObject;


public class PetJSONObjectData {
    static Faker faker;
    public static JSONObject data = new JSONObject();

    public static void setData(JSONObject data) {
        PetJSONObjectData.data = data;
        data.put("id", faker.idNumber().hashCode());

        JSONObject category = new JSONObject();
        category.put("id", 0);
        category.put("name", "dog");
        data.put("category", category);

        data.put("name", faker.name().firstName());

        String[] photoUrls = {"string"};
        data.put("photoUrls", photoUrls);

        JSONObject tag = new JSONObject();
        tag.put("id", faker.idNumber().hashCode());
        tag.put("name", faker.funnyName().name());
        String[] tags = {String.valueOf(tag)};
        data.put("tags", tags);

        data.put("status", "unavailable");

    }

}
