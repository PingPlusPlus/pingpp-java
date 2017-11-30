package com.pingplusplus.net;


public abstract class AccountAPIResource extends APIResource {

    public static String className(Class<?> clazz) {
        String className = APIResource.className(clazz);

        if (className.equals("royalty")) {
            return "royaltie";
        } if (className.equals("royaltysettlement")) {
            return "royalty_settlement";
        } if (className.equals("royaltytransaction")) {
            return "royalty_transaction";
        } if(className.equals("royaltytemplate")) {
            return "royalty_template";
        } else {
            return className;
        }
    }
}
