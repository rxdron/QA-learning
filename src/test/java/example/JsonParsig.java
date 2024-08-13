package example;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.*;

public class JsonParsig {

    ClassLoader cl = JsonParsig.class.getClassLoader();
    Gson gson = new Gson();
    ObjectMapper jackson = new ObjectMapper();

    @Test
    void jsonParsing() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("glossary.json");
                InputStreamReader reader = new InputStreamReader(resource)
                )
        {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.getAsJsonObject("glossary").get("title").getAsString())
                    .isEqualTo("example glossary");
            assertThat(jsonObject.getAsJsonObject("glossary").getAsJsonObject("GlossDiv")
                    .get("title").getAsString()).isEqualTo("S");

        }
    }

    @Test
    void jsonParsingTestWithGlossaryClass() throws Exception{
        try (
                InputStream resource = cl.getResourceAsStream("glossary.json");
                InputStreamReader reader = new InputStreamReader(resource)
        ) {
            GlossaryJson jsonGlossary = gson.fromJson(reader, GlossaryJson.class);
            assertThat(jsonGlossary.glossary.title).isEqualTo("example glossary");
            assertThat(jsonGlossary.glossary.glossDiv.title).isEqualTo("S");
            assertThat(jsonGlossary.glossary.glossDiv.glossList.glossEntry.id).isEqualTo("SGML");
            assertThat(jsonGlossary.glossary.glossDiv.glossList.glossEntry.glossSee).isEqualTo("markup");
            assertThat(jsonGlossary.glossary.glossDiv.glossList.glossEntry.glossDef.glossSeeAlso)
                    .containsExactly("GML", "XML");
        }
    }

    @Test
    void jsonParsingTestWithJacksonLibrary() throws Exception{
        try (
                InputStream resource = cl.getResourceAsStream("glossary.json");
                InputStreamReader reader = new InputStreamReader(resource))
        {
            JacksonGlossary jacksonGlossary = jackson.readValue(reader, JacksonGlossary.class);
            assertThat(jacksonGlossary.glossary.title).isEqualTo("example glossary");
            assertThat(jacksonGlossary.glossary.glossDiv.title).isEqualTo("S");
            assertThat(jacksonGlossary.glossary.glossDiv.glossList.glossEntry.glossDef.glossSeeAlso)
                    .containsExactly("GML", "XML");
        }
    }
}
