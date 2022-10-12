package org.jdcc.calculadora


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlin.math.pow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var num1 = 0F
    private var num2 = 0F
    private var total = 0F
    private var sign : String = ""
    private var newOperation : Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_result.text = "0"
        tv_0.setOnClickListener(this)
        tv_1.setOnClickListener(this)
        tv_2.setOnClickListener(this)
        tv_3.setOnClickListener(this)
        tv_4.setOnClickListener(this)
        tv_5.setOnClickListener(this)
        tv_6.setOnClickListener(this)
        tv_7.setOnClickListener(this)
        tv_8.setOnClickListener(this)
        tv_9.setOnClickListener(this)
        tv_plus.setOnClickListener(this)
        tv_minus.setOnClickListener(this)
        tv_times.setOnClickListener(this)
        tv_divider.setOnClickListener(this)
        tv_equals.setOnClickListener(this)
        tv_c.setOnClickListener(this)
        tv_delete.setOnClickListener(this)
        tv_point.setOnClickListener(this)
        //Para que no los tenga en cuenta en el modo vertical
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            tv_smile.setOnClickListener(this)
            tv_mod.setOnClickListener(this)
            tv_power.setOnClickListener(this)
            tv_pi.setOnClickListener(this)
            tv_ans.setOnClickListener(this)
        }
    }


    override fun onClick(v: View) {
        when(v.tag.toString()){
            "0" -> {
                if(newOperation) tv_result.text = ""    // Resetea el texto si se trata de una operacion nueva
                tv_result.text = tv_result.text.toString() + "0"
                newOperation = false
            }
            "1" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "1"
                newOperation = false
            }
            "2" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "2"
                newOperation = false
            }
            "3" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "3"
                newOperation = false
            }
            "4" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "4"
                newOperation = false
            }
            "5" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "5"
                newOperation = false
            }
            "6" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "6"
                newOperation = false
            }
            "7" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "7"
                newOperation = false
            }
            "8" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "8"
                newOperation = false
            }
            "9" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = tv_result.text.toString() + "9"
                newOperation = false
            }
            "point" -> {
                if(tv_result.text != "") {
                    tv_result.text = tv_result.text.toString() + "."
                }
            }
            "pi" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = "3.14"
                newOperation = false
            }
            "ans" -> {
                if(newOperation) tv_result.text = ""
                tv_result.text = total.toString()
                newOperation = false
            }


            "plus" -> {
                if(sign == "" && tv_result.text != "") {    // Evitar error de pulsar dos signos de operacion seguidos
                    num1 = tv_result.text.toString().toFloat()
                    sign = "+"
                    tv_result.text = ""
                    newOperation = false
                }
            }

            "minus" -> {
                if(sign == "" && tv_result.text != "") {
                    num1 = tv_result.text.toString().toFloat()
                    sign = "-"
                    tv_result.text = ""
                    newOperation = false
                }
            }

            "times" -> {
                if(sign == "" && tv_result.text != "") {
                    num1 = tv_result.text.toString().toFloat()
                    sign = "*"
                    tv_result.text = ""
                    newOperation = false
                }
            }

            "divider" -> {
                if(sign == "" && tv_result.text != "") {
                    num1 = tv_result.text.toString().toFloat()
                    sign = "/"
                    tv_result.text = ""
                    newOperation = false
                }
            }

            "mod" -> {
                if(sign == "" && tv_result.text != "") {
                    num1 = tv_result.text.toString().toFloat()
                    sign = "%"
                    tv_result.text = ""
                    newOperation = false
                }
            }

            "power" -> {
                if(sign == "" && tv_result.text != "") {
                    num1 = tv_result.text.toString().toFloat()
                    sign = "^"
                    tv_result.text = ""
                    newOperation = false
                }
            }

            "equals" -> {
                if(tv_result.text != "") {  // Evitar error si se pulsa sin introducir dato en pantalla
                    num2 = tv_result.text.toString().toFloat()
                    when (sign) {
                        "+" -> {
                            total = num1 + num2
                        }
                        "-" -> {
                            total = num1 - num2
                        }
                        "*" -> {
                            total = num1 * num2
                        }
                        "/" -> {
                            total = num1 / num2
                        }
                        "%" -> {
                            total = num1 % num2
                        }
                        "^" -> {
                            total = num1.pow(num2)
                        }


                        else -> tv_result.text = "Error"
                    }
                    tv_result.text = total.toString()
                    tv_last_oper.text = tv_last_oper.text.toString() + "\n$num1 $sign $num2 = $total "
                    num1 = total    // Se alamacena por si se realiza una operacion sobre el resultado
                    num2 = 0F
                    sign = ""
                    newOperation = true
                }
            }

            "c" -> {
                num1 = 0F
                num2 = 0F
                tv_result.text = ""
                newOperation = true
            }

            "delete" -> {
                if(tv_result.text != "") {  // Evitar error si se pulsa sin introducir dato en pantalla
                    var numCharac = tv_result.text.toString().length
                    tv_result.text = tv_result.text.toString().subSequence(0, numCharac - 1)
                }
            }

            "smile" -> Toast.makeText(this,"Don't worry, be happy! :D", Toast.LENGTH_SHORT).show()

            else -> tv_result.text = "Error"
        }
    }
}