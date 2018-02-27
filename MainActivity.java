package com.example.saurabhverma.myapplication;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    double[] operand = new double[15];
    char[] operator=new char[15];
    double temp=0;
    double tempEval=0;
    int i;
    int repeat=0;
    double answer=0;
    int answer_put=0;
    int t;
    int dec=0;
    double k=1;
    int flag=1;
    int correct=0;
    int point=0;
    int lengthOperand=0;
    int lengthOperator=0;
    String expression="";
    private void zerocheck()
    {
        if(expression=="0")
        {
            expression="";
        }
    }

    public void one(View view)
    {
        if(answer_put==0)
        {
            operandAdd(1);
            correct = 1;
            zerocheck();
            expression += 1;
            display();
        }
        else
            error();
    }
    public void two(View view)
    {
        if(answer_put==0)
        {
            operandAdd(2);
            correct = 1;
            zerocheck();
            expression += 2;
            display();
        }
        else
            error();
    }
    public void three(View view)
    {   if(answer_put==0)
        {
            operandAdd(3);
             correct = 1;
            zerocheck();
             expression += 3;
            display();
         }
        else
        error();
    }
    public void four(View view)
    {
        if(answer_put==0)
        {
            operandAdd(4);
            correct = 1;
            zerocheck();
            expression += 4;
            display();
        }
        else
            error();
    }
    public void five(View view)
    {   if(answer_put==0)
        {
            operandAdd(5);
             correct = 1;
             zerocheck();
             expression += 5;
        display();
         }
        else
        error();
    }
    public void six(View view)
    {   if(answer_put==0)
       {
            operandAdd(6);
           correct = 1;
           zerocheck();
          expression += 6;
           display();
       }
        else
        error();
    }
    public void seven(View view)
    {
        if(answer_put==0)
        {
            operandAdd(7);
            correct = 1;
            zerocheck();
            expression += 7;
            display();
        }
        else
            error();
    }
    public void eight(View view)
    {
        if(answer_put==0)
        {
            operandAdd(8);
            correct = 1;
            zerocheck();
            expression += 8;
            display();
        }
        else
            error();
    }
    public void nine(View view)
    {
        if(answer_put==0)
        {

            operandAdd(9);
            correct = 1;
            zerocheck();
            expression += 9;
            display();
        }
        else
            error();
    }

    public void zero(View view)
    {
        if(answer_put==0)
        {
            if (expression != "0") {
                operandAdd(0);
                correct = 1;
                expression += 0;
            }
            display();
        }
        else
            error();
    }
    public void add(View view)
    {
        if(correct==1) {
            setoperand();
            operatorAdd('+');
            expression += '+';
            display();
            answer_put=0;
            correct=0;
            point=0;
        }
        else
            error();
    }
    public void subtract(View view)
    {
        if(correct==1) {
            setoperand();
            operatorAdd('-');
            expression += '-';
            display();
            answer_put=0;
            correct=0;
            point=0;
        }
        else
            error();
    }
    public void multiply(View view)
    {
        if(correct==1) {
            setoperand();
            operatorAdd('*');
            expression += '*';
            display();
            answer_put=0;
            correct=0;
            point=0;
        }
        else
            error();
    }
    public void divide(View view)
    {
        if(correct==1) {
            setoperand();
            operatorAdd('/');
            expression += '/';
            answer_put=0;
            display();
            point=0;
            correct=0;
        }
        else
            error();
    }
    public void answer(View view)
    {
        if( (correct==0)&&(point==0))
        {
            if (expression == "0") {
                expression = "";
            }
            temp = answer;
            correct = 1;
            expression += "Ans";
            answer_put=1;
            point=0;
            display();
        }
        else
            error();

    }
    public void cancel(View view)
    {
        expression="0";
        for(i=0;i<15;i++)
        {
            operand[i]=0;
            operator[i]='0';
            lengthOperand=0;
            lengthOperator=0;
        }

        temp=0;
        point=0;
        answer_put=0;
        correct=0;
        display();
    }
    public void evaluate(View view)
    {
        if ((correct == 1)&&(lengthOperator>0))
        {
        setoperand();
        temp=0;
        eval();
        expression=""+operand[0];
        display();
        answer=operand[0];
            point=0;
        reset();
        }
        else
        {
            error();
        }
    }

    public void decimal(View view)
    {
        if((correct==1)&&(answer_put==0))

        {
            point=1;
            setoperand();
            operatorAdd('.');
            expression += '.';
            display();
            answer_put=0;
          correct=0;
        }
        else
            error();
    }
    public void display()
    {
         TextView expression_view=(TextView) findViewById(R.id.expression);

         expression_view.setText(expression);
    }
    public void error()
    {
        Toast.makeText(getApplicationContext(), "syntactical error", Toast.LENGTH_SHORT).show();

    }
    public void operandAdd(double num)

    {
        temp=temp*10+num;
    }

    public void operatorAdd(char ch)
    {
         operator[lengthOperator]=ch;
        lengthOperator++;
    }
    public void eval() {

            flag = 1;
            while (flag == 1) {
                flag = 0;
                for (i = 0; i <lengthOperator; i++) {
                    if (operator[i] == '.') {
                        dec = 1;
                        k = operand[i + 1];
                        while (k >= 1) {
                            k = k / 10;
                            dec = dec * 10;

                        }
                        operand[i] = operand[i] + (operand[i + 1] / dec);
                        setLength(i);
                        lengthOperand--;
                        lengthOperator--;

                        flag = 1;
                        break;
                    }
                }
            }
             flag = 1;
             while (flag == 1)
             {
                 flag = 0;
                 for (i = 0; i <lengthOperator; i++) {
                  if (operator[i] == '/')
                  {
                    operand[i] = operand[i] / operand[i + 1];
                    setLength(i);
                    lengthOperand--;
                    lengthOperator--;

                    flag = 1;
                    break;
                 }
             }
        }
            flag = 1;
            while (flag == 1)
            {
                flag = 0;
                for (i = 0; i < lengthOperator; i++)
                {
                    if (operator[i] == '*')
                    {
                        operand[i] = operand[i] * operand[i + 1];
                        setLength(i);
                        lengthOperand--;
                        lengthOperator--;

                        flag = 1;
                        break;
                    }
                }
            }

            flag = 1;
            while (flag == 1) {
                flag = 0;
                for (i = 0; i <lengthOperator; i++) {
                    if (operator[i] == '+') {
                        operand[i] = operand[i] + operand[i + 1];
                        setLength(i);
                        lengthOperand--;
                        lengthOperator--;

                        flag = 1;
                        break;
                    }
                }
            }
            flag = 1;
            while (flag == 1) {
                flag = 0;
                for (i = 0; i <lengthOperator; i++) {
                    if (operator[i] == '-') {
                        operand[i] = operand[i] - operand[i + 1];
                        setLength(i);
                        lengthOperand--;
                        lengthOperator--;

                        flag = 1;
                        break;
                    }
                }
            }
    }
    public void setoperand()
    {
        operand[lengthOperand] =temp;
        temp=0;
        lengthOperand++;
    }
    public void setLength(int j)
    {

         for (t=j+1;t<=lengthOperand;t++)
         {
             operand[t]=operand[t+1];
             operator[t-1]=operator[t];

         }
    }
    public void reset()
    {
        expression="0";
        for(i=0;i<15;i++)
        {
            operand[i]=0;
            operator[i]='0';
            lengthOperand=0;
            lengthOperator=0;
        }
        temp=0;
        correct=0;
    }
    public void cancelSingle(View view)
    {
        if(expression.charAt(expression.length() - 1)=='s')
        {
            expression = expression.substring(0, expression.length() - 3);
            answer_put=0;
            temp=0;
            correct=0;
            display();
            return;
        }
        else if((correct==0)&&(lengthOperator>0))
        {
            operator[lengthOperator-1]='0';
            lengthOperator=lengthOperator-1;
            expression = expression.substring(0, expression.length() - 1);
            display();
            correct=1;
            temp=operand[lengthOperand-1];
            lengthOperand--;

            return;
        }

        else if(correct==1)
        {
            if((temp==0)&&(lengthOperator>0))
            {
                temp=operand[lengthOperand-1];
                lengthOperand--;
                correct=1;
            }
            temp= (temp-(temp%10))/10;
            if(expression.length()>1)
            {
                expression = expression.substring(0, expression.length() - 1);
                if(temp==0)
                {
                    correct=0;
                }
                else
                    correct=1;
            }
            else
            {
                lengthOperator=0;
                correct=0;
                expression="0";
            }
            display();
            return;
        }

        else
        {
            error();
        }

    }
}