package ru.netology

fun main() {

    var userTime = 60 //время отсутствия пользователя в секундах

    while (userTime < 270600) {
        println("Пользователь был(а) в сети " + agoToText(userTime))
        userTime += 1600
    }


}

fun agoToText(userTime:Int): String {

    val secondMin = 60
    val minuteHour = 60
    val hourDay = 24
    val secondHour = secondMin * minuteHour
    val secondDay = hourDay * minuteHour * secondMin
    val minuteUser = userTime / minuteHour
    val hourUser = userTime / secondHour

    return when (userTime) {
        in 0..secondMin -> "только что"
        in secondMin + 1..secondHour -> "" + minuteUser + " " + getTextEnding(minuteUser, "minute") + " назад"
        in secondHour + 1..secondDay -> "" + hourUser + " " + getTextEnding(hourUser, "hour") + " назад"
        in secondDay + 1 .. secondDay * 2 -> "вчера"
        in secondDay * 2 + 1 .. secondDay * 3 -> "позавчера"
        else -> "давно"
    }
}

fun getTextEnding(time:Int, state:String): String {

    val remainder10 = time % 10;
    val remainder100 = ((time - remainder10) / 10) % 10;

    if (remainder100 != 1) {
        return when (state) {

            "minute" -> when (remainder10) {
                1 -> "минуту"
                2, 3, 4 -> "минуты"
                else -> "минут"
            }

            "hour" -> when (remainder10) {
                1 -> "час"
                2, 3, 4 -> "часа"
                else -> "часов"
            }

            else -> getWhenTime(state)
        }


    }

    return getWhenTime(state)

}

fun getWhenTime(state:String): String {
    return when (state) {
        "minute" -> "минут"
        "hour" -> "часов"
        else -> ""
    }
}