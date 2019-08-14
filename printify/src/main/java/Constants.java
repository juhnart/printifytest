public final class Constants {

    static final String host = "https://api.printify.com";
    static final String basePath = "/v1";
    static final String shops = "/shops.json";
    static final String products = "/shops/{id}/products.json";
    static final String product =  "/shops/{shop_id}/products/{product_id}.json";
    static final String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjZhMmZjNjc3NDA3ZDRiMTJjNjIzZjNjMjU4MGFhMGRlNmZiOTIwNWJlMDRjNmVjOTBiYjc4ZTkzNGQyNmI5YTdmOGE1YTg5ODk5NDE1NmEyIn0.eyJhdWQiOiIzN2Q0YmQzMDM1ZmUxMWU5YTgwM2FiN2VlYjNjY2M5NyIsImp0aSI6IjZhMmZjNjc3NDA3ZDRiMTJjNjIzZjNjMjU4MGFhMGRlNmZiOTIwNWJlMDRjNmVjOTBiYjc4ZTkzNGQyNmI5YTdmOGE1YTg5ODk5NDE1NmEyIiwiaWF0IjoxNTY1Njc2MzQ4LCJuYmYiOjE1NjU2NzYzNDgsImV4cCI6MTU5NzI5ODc0OCwic3ViIjoiNjc5ODg0MyIsInNjb3BlcyI6WyJzaG9wcy5yZWFkIiwiY2F0YWxvZy5yZWFkIiwib3JkZXJzLnJlYWQiLCJvcmRlcnMud3JpdGUiLCJwcm9kdWN0cy5yZWFkIiwicHJvZHVjdHMud3JpdGUiLCJ3ZWJob29rcy5yZWFkIiwid2ViaG9va3Mud3JpdGUiLCJ1cGxvYWRzLndyaXRlIiwicHJpbnRfcHJvdmlkZXJzLnJlYWQiXX0.AEFxyljrRpAUnX6t-DtbyuED23Fxfb1qb5cCcXcFCe43ZmyV9vWrLjwXq-gzJayvofbD6Q6N_8REDihkoUo";
    static final String updateProductBody = "{\n" +
            "    \"description\": \"%s\"\n" +
            "}";
    static final String newProductBody = "{\n" +
            "    \"title\": \"Product\",\n" +
            "    \"description\": \"%s\",\n" +
            "    \"blueprint_id\": 384,\n" +
            "    \"print_provider_id\": 1,\n" +
            "    \"variants\": [\n" +
            "          {\n" +
            "              \"id\": 45740,\n" +
            "              \"price\": 400\n" +
            "          },\n" +
            "          {\n" +
            "              \"id\": 45742,\n" +
            "              \"price\": 400\n" +
            "          },\n" +
            "          {\n" +
            "              \"id\": 45744,\n" +
            "              \"price\": 400\n" +
            "          },\n" +
            "          {\n" +
            "              \"id\": 45746 ,\n" +
            "              \"price\": 400\n" +
            "          }\n" +
            "      ],\n" +
            "      \"print_areas\": [\n" +
            "        {\n" +
            "          \"variant_ids\": [45740,45742,45744,45746],\n" +
            "          \"placeholders\": [\n" +
            "            {\n" +
            "              \"position\": \"front\",\n" +
            "              \"images\": [\n" +
            "                  {\n" +
            "                    \"id\": \"5d51a464b887d100087d14c8\", \n" +
            "                    \"x\": 0.5, \n" +
            "                    \"y\": 0.5, \n" +
            "                    \"scale\": 1,\n" +
            "                    \"angle\": 0\n" +
            "                  }\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "  }";


}
