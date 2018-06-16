public void loginPsychologist(){
//FAZER ISSO DENTRO DO CONTROLLER, CHECAR TODO O FLUXO DO ENVIO DE HTTP 
    post("/login/psychologist", new Route() {
        @Override
        public Object handle(final Request request, final Response response){
            response.header("Access-Control-Allow-Origin", "*");
            JSONObject json = new JSONObject(request.body());
            String userName = json.getString("userName");
            String password = json.getString("password");
            try {
                Psychologist psychologist = model.loginPsychologist(userName, password);
                if(psychologist != null){
                    JSONArray jsonResult = new JSONArray();
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("status", 1);
                    jsonObj.put("userName", psychologist.getUserName());
                    jsonResult.put(jsonObj);
                    return jsonResult;
                } else {
                }
            } catch (JSONException e) {
            //e.printStackTrace();
            }
            JSONArray jsonResult = new JSONArray();
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("status", 0);
            jsonResult.put(jsonObj);
            return jsonResult;	
        }
    });     
}
