package example;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GlossaryJson {

    public Glossary glossary;



    public static class Glossary{
        public String title;

        @SerializedName("GlossDiv")
       public GlossDiv glossDiv;

    }

    public static class GlossDiv{
        String title;

        @SerializedName("GlossList")
        public GlossList glossList;
    }

    public static class GlossList{

        @SerializedName("GlossEntry")
        public GlossEntry glossEntry;
    }

    public static class GlossEntry{

        @SerializedName("ID")
        public String id;

        @SerializedName("SortAs")
        public String sortAs;

        @SerializedName("GlossTerm")
        public String glossTerm;

        @SerializedName("Acronym")
        public String acronym;

        @SerializedName("Abbrev")
        public String abbrev;

        @SerializedName("GlossSee")
        public String glossSee;

        @SerializedName("GlossDef")
        public GlossDef glossDef;
    }

    public static class GlossDef{
        public String para;

        @SerializedName("GlossSeeAlso")
        public List<String> glossSeeAlso;
    }
}

