package com.project.aplikasi.pemesanan_makanan.config;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.project.aplikasi.pemesanan_makanan.activity.login_activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class config_global {
    public static final String BASE_URL = "https://66ee-114-122-4-165.ap.ngrok.io/2022_Fadiah_pemesanan_makanan/server/";

    config_sessionmanager config_sessionmanager;

    public final String ambil(Activity activity) {
        config_sessionmanager = new config_sessionmanager(activity);
        return config_sessionmanager.getSPToken();
    }

    public final String ambil(Context context) {
        config_sessionmanager = new config_sessionmanager(context);
        return config_sessionmanager.getSPToken();
    }

    public final boolean checkTokenOlineIsValid(Activity activity, int response_code){
        if (response_code == 401){
            Intent intent = new Intent(activity, login_activity.class);
            activity.finishAffinity();
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // hapus semua history
            activity.startActivity(intent);
            Toast.makeText(activity, "Session Expired", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    public String capitalize(String capString){
        StringBuffer capBuffer = new StringBuffer();
        Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(capString);
        while (capMatcher.find()){
            capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() + capMatcher.group(2).toLowerCase());
        }

        return capMatcher.appendTail(capBuffer).toString();
    }

    private static final String ALPHA_NUMERIC_STRING =
            "0123456789";
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generate_id(Activity activity, String tabel){
        String id = new config_sessionmanager(activity).getSPId();
		tabel = tabel.replace( "data_","" );
        tabel = tabel.substring( 0,3 );
        tabel = tabel.toUpperCase();
        String date =
                new SimpleDateFormat("ddMMyyyyHHmmss").format(Calendar.getInstance().getTime());
        return tabel+id+date+randomAlphaNumeric(3);
    }

    AlertDialog alertDialog;
    public AlertDialog createLoading(Activity activity, String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false);
        alertDialog = alertDialogBuilder.create();
        return alertDialog;
    }
	
	
	  public static List<InputTypeItem> inputTypes;
    public static void init_inputTypes() {
        inputTypes = new ArrayList<>();
        inputTypes.add(new InputTypeItem("date",  InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_DATE));
        inputTypes.add(new InputTypeItem("datetime", InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_NORMAL));
        inputTypes.add(new InputTypeItem("none", InputType.TYPE_NULL));
        inputTypes.add(new InputTypeItem("number",  InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL));
        inputTypes.add(new InputTypeItem("numberDecimal",  InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL));
        inputTypes.add(new InputTypeItem("numberPassword",  InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD));
        inputTypes.add(new InputTypeItem("numberSigned", InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED));
        inputTypes.add(new InputTypeItem("phone",  InputType.TYPE_CLASS_PHONE));
        inputTypes.add(new InputTypeItem("text",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL));
        inputTypes.add(new InputTypeItem("textAutoComplete", InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE));
        inputTypes.add(new InputTypeItem("textAutoCorrect",  InputType.TYPE_TEXT_FLAG_AUTO_CORRECT));
        inputTypes.add(new InputTypeItem("textCapCharacters",  InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS));
        inputTypes.add(new InputTypeItem("textCapSentences",  InputType.TYPE_TEXT_FLAG_CAP_SENTENCES));
        inputTypes.add(new InputTypeItem("textCapWords",  InputType.TYPE_TEXT_FLAG_CAP_WORDS));
        inputTypes.add(new InputTypeItem("textEmailAddress",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS));
        inputTypes.add(new InputTypeItem("textEmailSubject", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT));
        inputTypes.add(new InputTypeItem("textFilter",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_FILTER));
        inputTypes.add(new InputTypeItem("textLongMessage",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE));
        inputTypes.add(new InputTypeItem("textMultiLine",  InputType.TYPE_TEXT_FLAG_MULTI_LINE));
        inputTypes.add(new InputTypeItem("textNoSuggestions", InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS));
        inputTypes.add(new InputTypeItem("textPassword",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD));
        inputTypes.add(new InputTypeItem("textPersonName", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME));
        inputTypes.add(new InputTypeItem("textPhonetic",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PHONETIC));
        inputTypes.add(new InputTypeItem("textPostalAddress", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS));
        inputTypes.add(new InputTypeItem("textShortMessage", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE));
        inputTypes.add(new InputTypeItem("textUri",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_URI));
        inputTypes.add(new InputTypeItem("textVisiblePassword",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD));
        inputTypes.add(new InputTypeItem("textWebEditText",  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT));
        inputTypes.add(new InputTypeItem("textWebEmailAddress", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS));
        inputTypes.add(new InputTypeItem("textWebPassword", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD));
        inputTypes.add(new InputTypeItem("time", InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_TIME));
    }

    public static class InputTypeItem {
        public int value;
        public String name;
        InputTypeItem(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
}



















