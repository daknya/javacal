# Calculator

so what is calculator 
 calculator is a programme used to simplify the calculation process for us

 ## how to make one in android studio

 to create a calculator you first need to learn   
   android studio xml ,  
 arithmetic operator ,  
 control statement (switch),  
 java eventlisteners,  
  string methods  ,  
    reggular expression in java ,   
    array,  
    function,  
 i will explain the topic which where used to create this 
### Xml used
This are units used 
dp ->
> Density-independent Pixels - an abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp"

sp->
> Scaleable Pixels OR scale-independent pixels - this is like the dp unit, but it is also scaled by the user's font size preference. It is recommended you use this unit when specifying font sizes, so they will be adjusted for both the screen density and the user's preference. Note, the Android documentation is inconsistent on what sp actually stands for, one doc says "scale-independent pixels", the other says "scaleable pixels".

<hr> 

####  this wil be the parent layout 
> <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"


here is Linearlayout is view group layout which can contain different number of view  and can set it orientation to vertical or horizontal 


the next line some kind of package 

>    android:layout_width="match_parent"
    android:layout_height="match_parent"


 we have width and height here we set them to match_parent which means the width and height will be same as the parent element 

>  android:layout_weight="1"  
    android:weightSum="5"


 now set layout_weight to 1  , it means that this will occupy 1 space of the parent wieght weigth sum since the parent weightsum is 1 by default the is will occupy whole space for its own  
  and the we have set weightSum to 5 which means it will have 5 child element 

  > android:orientation="vertical"

now set the orientation to vertical as we have discussed that the linear layout can be set to two orientation  first is horizontal and verticel 
 <hr>

####  NOW LETS CREATE  SCREEN(first child)

> <TextView  
.        android:id="@+id/screen"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_gravity="center|right"
        android:layout_marginHorizontal="10dp"
        android:layout_marginBottom="30dp"
        android:layout_margin="10dp"
        android:layout_weight="1"
        android:textColor="#303034"
        android:textSize="30sp"
        android:textStyle="bold"
        android:background="#CED8D5"
        android:padding="5dp"
        /> 

textview is and XML tag to creat textview we will use this as our screen to display the output of our operation

lets dicusses the attributes 

<strong>android:id</strong>  -> this is create an unique id for the this tag which we will use later to access this element 

android:layout_width ;
android:layout_height ; -> it is same as dicussed earlier 


<strong> android:gravity </strong> -> its sets the position where the child of the element will go in this case the child refer to the output text

<strong> layout margin</strong> -> this set gap between the element to its surrounding element 

>  android:textColor="#303034"  
        android:textSize="30sp"  
        android:textStyle="bold"  
        android:background="#CED8D5"

hope you are able to understand what this are doing 
<hr>
<stong>padding</strong> it set space between element and the border in this case 5dp



#### LETS CREATE THE BUTTONS

first we need a parent container which we anable use to set the direction of its element 
as we have dicussed earlier linear layout anables use to do that with its orientation property



> <LinearLayout  
        android:layout_width="match_parent"
        android:layout_height= "0dp"
        android:layout_weight="1"
        android:weightSum="4"
        >
 
 here the layout weight is set to 1 because we want it to take up 1 space of the parent element which was set to 5 if u remember

  inside this we need 4 child element (buttons) so we set its weight sum to 4 

  notice there is no orientation properties still the oreientation is horizontal ?? why? because it is its default value 



  for button we have  
  < button > tag
 >  < Button  
   android:id="@+id/ac"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:text="ac"
            android:layout_margin="5dp"
            android:onClick="buttonclick"
            android:textColor="#EADDDD"
            android:textSize="30dp"
            android:background="@drawable/button"
   />

this is our button by which we will take our input


>android:id="@+id/ac"

its sets the id of that element which will be helpful to will accessing them 

here 
>android:onClick="buttonclick"

is an eventlistener which mean when ever we click the button it will trigger the funtion buttonclick
>android:text= " "

sets the text inside that button we set it to all clear 


<strong>  NOW ALL YOU NEED TO DO IS COPY BUTTON 3 TIMES INSIDE ITS PARENT ELEMENT
</strong>

<STRONG> 
AND THEN DO  COPY THAT PARENT LINEAR LAYOUT ( WITH BUTTONS TOO(-_-) ) AND </STRONG>

AND YOUR ARE GOOD TO ----   activity_main.java  -- GO WITH THE JAVA CODE 

# activity_main.java

>package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
AppCompatActivity {  
    @Override  
         protected void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
    }
}

when ever you creat a new file android studio will create this on default 

FIRST this java dont know what your layout/design/xml elements
therefore we have to create there variable and or those element 
 inside AppCompatActivity
 before @override 
> private Textview = variable_name; in our case keep it screen 


now create 2 move varables 
 >String input = ""  
 - this will contain the input of we get for events (button click)
 >Boolean clearresult;
 - to cheak if the sceen should be cleared or not



 ## INPUT TO SCREEN

for that we need get the textveiw view and assigned it to our screen variable

(in side on create function)

>screen = findViewById(R.id.screen)
- now screen in this java fill means the screen in our layout

 as we have set onClick listener to the xml file so lets create that function/ method (- -)

> public void buttonclick(View view){
>
>
> }

this is the funtion that will be called every time we click the  button 

- HOW IS OUR JAVA GOING TO KNOW WHAT BUTTON WE ARE PRESSING

lets see 

look at the parameters of funtion it is View view it will accept View type and the varibale name is view
which mean when ever we click the button then all of its attribute will be passed to this function 

- HOW TO ACCESSES THE ATTRIBUTE/PROPERTIES OF THIS ELEMENT 

in java the are bulti in function to access this value
> getText() etc.

inside that function first of all we intialize the button that is clicked 
for that we do 
>Button button = (Button) view

Button is the type button is the vaiable name (Button) is java type casting the view to Button

now we hava to get the text in that button for that

> String data = button.getText().toString();

this  will patch the text and turn it into string the data will be stored in the data


- NOW WHAT HOW ARE WE GOING TO ADD? HOW ?

so ever time the button is click then the text of that button will be stored which will be later diplayed in the screen HOW?

>screen.setText(data);
 
 inside the buttonclick method 

 this will display what ever you have clicked  to the screen 
 but that is use less so what do do now

 now lets lets creat an flow controll statement for define type of flow during different button click 

 if it ac(all clear)
 then we have to set the input to " "

 > case "ac":  
  input = "";  
  break;

 = (equals)  
 then we will set the boolean clearresult to true (why? wait !)
 > case "="
   clearresult = true; 
    solve();
    break;

so  when ever after clicking = you press any numeric value the it should display only the recent value otherwise it will just concat the recent pressed value to last result 

now thats all the special cases 

 then set default 

 > if(data.equals("-") || data.equals("+") || data.equals ("/") || data.equals("*")){  
    //then  set clear result to false (why?wait)  
    clearresult = false;
    solve();
 }  
 else if(clearresult == true){  
       input ="";  
       clearresult= false;  
 }  
 input += data; //     
  this will set whatever data was clicked to  input 

#  SOLVING THE EQUATION

 - for solving we will use string methods .spilt() .length 
 
> if (input.split("\\+").length == 2){
    }



this statement checks if there is + operator in the input after .. .length == 2  
why is this because somethis some integer are signed like negative or positive 
so the sign will be in the first index hope fully 

now inside this we will do the maths
 
 HOW? 
 first we will slipt the input into two string with split method
> {  
  String[] number = input.split("\\+");
  
 }
 so the split method splits the string around the mathcs of the given regular expression and it returns and array 
 
 to preform addition we need to convert the string to double 

 >double add = Double.parseDouble(number[0])+Double.parseDouble(number[1]);

 now we just need to assigne this value to input 

 > input +=add;

 just do the same for other operation too

 but in case of negetive number check if the split method have divided it into how many pieces

 if its two the it means there was no negative integer 
> if(number.length == 2){  
    double sub = Double.parseDouble(number[0])-Double.  parseDouble(number[1]);   
    input+=sub; 
}
 if its splits it into 3 this means there is one -integer 

 > if ( number.length == 3){  
     double sub = -Double.parseDouble(number[0])-Double.  parseDouble(number[1]);  
     input +=sub;
 }

 and thats it
 


 



 



 