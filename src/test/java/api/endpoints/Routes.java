package api.endpoints;

public class Routes {
    // making it public so that it can be accessed anywhere in the project
    //making it static so that i use can this variable directly using the class name with out using any object

        public static String base_url="https://petstore.swagger.io/v2" ;

        //User module

        public static String post_url=base_url+"/user";
        public static String get_url=base_url+"/user/{username}";
        public static String update_url=base_url+"/user/{username}";
        public static String delete_url=base_url+"/user/{username}";

        //Store module
        public static String post_order_url = base_url+ "/store/order";
        public static String get_order_url = base_url+ "/store/order/{orderId}";
        public static String delete_order_url = base_url+ "/store/order/{orderId}";


        //Pet module

        public static String post_pet_url = base_url+"/pet";
        public static String get_pet_url = base_url+"/pet/{petid}";
        public static String update_pet_url = base_url+"/pet";
        public static String delete_pet_url = base_url+"/pet/{petid}";


    }


