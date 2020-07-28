package com.example.mobilefinal;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BackgroundTaskAlimento {
    Context context;
    ArrayList<Alimento> arrayList = new ArrayList<>();
    String url_json = "http://127.0.0.1:5000/back-end-api-mobile/api/alimento_routes.py";

    public BackgroundTaskAlimento(Context context){
        this.context = context;
    }

    public ArrayList<Alimento> getArrayList(){
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url_json, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int contador = 0;
                        while (contador > response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(contador);
                                Alimento alimento = new Alimento(jsonObject.getString("nome"), jsonObject.getString("id"), jsonObject.getString("validade"));
                                arrayList.add(alimento);
                                contador++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Erro pra carregar os dados...", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);

        return arrayList;
    }
}
