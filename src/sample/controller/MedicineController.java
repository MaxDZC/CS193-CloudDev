package sample.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.MedicineDto;
import sample.service.MedicineService;

public class MedicineController extends Controller {

    /**
     * Service object that will be used to call CRUD functions to datastore
     */
    MedicineService medicineService = new MedicineService();


    /**
     * For now, used to insert a 'medicine' entity to the datastore
     */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("MedicineController.run start");

        JSONObject json = new JSONObject();
        String action = request.getParameter("action");


        /** 
         * Used to retrieve the JSON equivalent data
         */
        BufferedReader br = request.getReader();
        String str = null;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        /**
         * Used to store the information from the request and send to the
         * service class.
         */
   MedicineDto medicineDto = new MedicineDto(jObj.getString("name"),
                                                      jObj.getString("desc"),
                                                      Double.parseDouble(jObj.getString("price"))
                                                     );
        if (action.equals("registerMedicine")) {


            if (medicineService.insertMed(medicineDto) == false) {

                json.put("message", "duplicated");

            } else {

                json.put("message", true);

            }

        } else if (action.equals("updateMedicine")) {


            if (MedicineService.updateMedicine(medicineDto)) {
                json.put("message", "Medicine record updated ");
            } else {
                json.put("message", false);
            }

        } else if (action.equals("deleteMedicine")) {
            if (MedicineService.deleteMedicine(medicineDto)) {

                json.put("message", "Medicine record deleted ");
            } else {
                json.put("message", false);
            }

        } else if (action.equals("getMedicine")) {

            json.put("medicines", MedicineService.getMedicine(jObj.getString("name")));
        } else if (action.equals("getMedicines")) {
            json.put("medicines", MedicineService.getMedicines());
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //print JSon
        out.print(json.toString());

        System.out.println("MedicineController.run end");
        //screen redirection.
        return null;
    }
}