package example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class JacksonGlossary {
    public JacksonGlossary.Glossary glossary;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Glossary{
        public String title;

        @JsonProperty("GlossDiv")
        public JacksonGlossary.GlossDiv glossDiv;

    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GlossDiv{
        @JsonProperty("title")
        String title;

        @JsonProperty("GlossList")
        public JacksonGlossary.GlossList glossList;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GlossList{

        @JsonProperty("GlossEntry")
        public JacksonGlossary.GlossEntry glossEntry;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GlossEntry{

        @JsonProperty("ID")
        public String id;

        @JsonProperty("SortAs")
        public String sortAs;

        @JsonProperty("GlossTerm")
        public String glossTerm;

        @JsonProperty("Acronym")
        public String acronym;

        @JsonProperty("Abbrev")
        public String abbrev;

        @JsonProperty("GlossSee")
        public String glossSee;

        @JsonProperty("GlossDef")
        public JacksonGlossary.GlossDef glossDef;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GlossDef{
        public String para;

        @JsonProperty("GlossSeeAlso")
        public List<String> glossSeeAlso;
    }
}
