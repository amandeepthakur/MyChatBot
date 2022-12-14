package com.example.mychatbot_1.utils

import com.example.mychatbot_1.utils.Constants.OPEN_GOOGLE
import com.example.mychatbot_1.utils.Constants.OPEN_SEARCH
import com.example.mychatbot_1.utils.Constants.OPEN_CAMERA
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..5).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //Hello
            message.contains("hello")|| message.contains("hlo") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Buongiorno!"
                    3-> "Hi"
                    4-> "Hey"
                    5-> "Hola"


                    else -> "Error"
                     }
            }
            //INTRODUCTION
            message.contains("Introduce")|| message.contains("name") -> {
                "Hi, I'm your assistant"
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    3 -> "I'm tired!!!"
                    4 -> "I'm doing great, thanks for asking!"
                    5 -> "I'm doing fine, thanks for asking!"

                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }
            // Open Camera
            message.contains("open") && message.contains("camera")->{
                OPEN_CAMERA
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "I don't know what you mean"
                    3 -> "I'm not sure what you're asking"
                    4 -> "I'm sorry, I don't know the answer to that"
                    5 -> "I'm not sure what you mean"
                    else -> "error"
                }
            }
        }
    }
}