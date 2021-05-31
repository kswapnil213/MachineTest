package in.nilapps.machinetest.modules.category;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import in.nilapps.machinetest.common.data.models.Category;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class CategoryModel implements CategoryContract.Model {

    @Override
    public void getCategoryDataFromServer(Context context, OnVolleyResponseListener onVolleyResponseListener) {

        //Todo: URL and API call has been commented for privacy concern
        /*RequestQueue mRequestQueue = Volley.newRequestQueue(context);

        String url = "test_url";
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, url,

                response -> onVolleyResponseListener.onSuccess((new Gson()).fromJson(response, Category.class)),

                error -> onVolleyResponseListener.onFailure(error));

        mRequestQueue.add(mStringRequest);*/

        onVolleyResponseListener.onSuccess((new Gson()).fromJson(apiResponse, Category.class));

    }

    String apiResponse = "{\n" +
            "    \"status\": \"SUCCESS\",\n" +
            "    \"statusCode\": \"200\",\n" +
            "    \"message\": \"Success\",\n" +
            "    \"component\": [\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Kitchen & Dining\",\n" +
            "                \"categoryId\": \"607\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/6.jpg\",\n" +
            "                \"subTitle\": \"Cookware \",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=607&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Dining ware\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=610&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Drinkware & Flatware\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=612&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Dallah & Flask\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=613&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Hot pot\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=614&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Kitchen Tools & Gadgets\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=615&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Serveware & Trays\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=616&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Table Decoration & Accessories\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=617&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Cookware \",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=788&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Kitchen Appliances\",\n" +
            "                \"categoryId\": \"618\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/7.jpg\",\n" +
            "                \"subTitle\": \"Blenders & Juicers\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=618&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Microwave & ovens\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=619&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Coffee Makers\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=620&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Electric Kettles\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=621&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Baking mixer\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=622&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Air Fryers\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=623&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Small Appliances\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=624&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Cooking Appliances\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=625&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Blenders & Juicers\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=626&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Household Appliances\",\n" +
            "                \"categoryId\": \"627\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/8.jpg\",\n" +
            "                \"subTitle\": \"Heaters\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=627&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Air Conditioners & Humidifier\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=630&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Cleaning Appliances\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=631&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Small Appliances\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=632&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Personal Care Appliances\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=635&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Heaters\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=691&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Bathrooms\",\n" +
            "                \"categoryId\": \"636\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/1.jpg\",\n" +
            "                \"subTitle\": \"Laundry Baskets & Hampers\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=636&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Bathroom Accessories Sets\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=637&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Laundry Baskets & Hampers\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=641&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Exterior Decor\",\n" +
            "                \"categoryId\": \"646\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/4.jpg\",\n" +
            "                \"subTitle\": \"Decor Exterior\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=646&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Plants Pots\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=648&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Decor Exterior\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=694&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Interior Decor\",\n" +
            "                \"categoryId\": \"653\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/2.jpg\",\n" +
            "                \"subTitle\": \"Decore Interior\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=653&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Boxes & Storage\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=654&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Candles & Holders\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=655&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Vases & Jars\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=656&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Wastebasket\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=657&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Flowers & Plants Pots\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=695&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Plants & Flowers\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=697&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Figurines & Statues\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=786&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Accent Tables\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=800&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Decore Interior\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=801&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Wall Decor\",\n" +
            "                \"categoryId\": \"662\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/5.jpg\",\n" +
            "                \"subTitle\": \"Hanging & Shelves Decor\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=662&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Clocks\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=663&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Artwork\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=664&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Drawings & Paintings\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=666&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Mirrors\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=699&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"title\": \"Hanging & Shelves Decor\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=700&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"componentId\": \"categoryTab\",\n" +
            "            \"sequenceId\": \"1\",\n" +
            "            \"isActive\": \"1\",\n" +
            "            \"categoryTabData\": {\n" +
            "                \"title\": \"Electronics\",\n" +
            "                \"categoryId\": \"669\",\n" +
            "                \"backgroundImage\": \"https://demedia.hayatmart.com/pub/media/catalog/category/3.jpg\",\n" +
            "                \"subTitle\": \"Security Camera\",\n" +
            "                \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=669&brandId=\",\n" +
            "                \"type\": \"1\",\n" +
            "                \"navigationFlag\": \"0\",\n" +
            "                \"level2\": [\n" +
            "                    {\n" +
            "                        \"title\": \"Security Camera\",\n" +
            "                        \"query\": \"https://staging.hayatmart.com/rest/default/V1/ecomapi/productList?authToken=Bearer+xi4wgqmf9e8kyf28mnyhdwi7i58wpgsv&customerId=6&groupId=1&storeId=1&websiteId=1&categoryId=690&brandId=\",\n" +
            "                        \"type\": \"1\",\n" +
            "                        \"navigationFlag\": \"1\"\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";

}
