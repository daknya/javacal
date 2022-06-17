package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private TextView screen;
 private String input="" ;
 private boolean clearresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.screen);
    }
    public void buttonclick(View view){

        Button button =(Button) view;

        String data = button.getText().toString();


        switch (data){
            case "ac":
                input="";
                break;

          /*  case "*":
                clearresult = false;
                solve();
                input+="*";
                break;
*/

            case "=":
                clearresult=true;
                solve();
            //    answer = input;
                break;
            default:
             /*   if(input == null){
                    input = "";
                }*/
                if (data.equals("+") || data.equals("-") || data.equals("/") || data.equals("*")){
                    clearresult= false;
                    solve();
                }
                else if(clearresult){
                    input = "";
                    clearresult = false;
                }
                input +=data;
        }
        screen.setText(input);

    }
    public void solve(){


        if(input.split("\\*").length==2){
            String numbers[]=input.split("\\*");
            try{
                double mul=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                input=mul+"";
            }
            catch (Exception e){
                //Display error
                System.out.println(e);
            }
        }
        if(input.split("\\+").length ==2){
            String numbers[] = input.split("\\+");
            try{
                double sum = Double.parseDouble(numbers[0] )+ Double.parseDouble(numbers[1]);
                input =  sum+"";
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(input.split("\\/").length==2){
            String numbers[] = input.split("\\/");
            try{
                double div = Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                input = div+"";
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
        else if(input.split("\\-").length>1){
            String numbers[]=input.split("\\-");

            try{
                double sub=0;
                if(numbers.length==2) {
                    sub = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                }
                else if(numbers.length==3){
                    sub = -Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[2]);
                }
                input=sub+"";
            }
            catch (Exception e){
                //Display error
            }
        }
        screen.setText(input);
    }

}