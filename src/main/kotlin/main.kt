fun main() {
    val time = 168000
    println(informer(time))
}

fun informer(time: Int): String {
    val infoTime = when (time) {
        in 0..60 -> "только что"
        in 61..60*60 -> formatMinute(time)
        in 60*60+1..24*60*60 -> formatHour(time)
        in 24*60*60+1..2*24*60*60 -> "сегодня"
        in 2*24*60*60+1..3*24*60*60 -> "вчера"
        else -> "давно"
    }
    return infoTime
}

fun formatMinute(time: Int): String {
    val minute = time / 60
    var answ = ""
    if (minute % 10 in 5..9 || minute in 10..20) {
        answ = "$minute минут назад"
    } else if (minute % 10 in 2..4) {
        answ = "$minute минуты назад"
    } else if (minute % 10 == 1) {
        answ = "$minute минуту назад"
    }
    return answ
}

fun formatHour(time: Int): String {
    val hour = time / 3600
    var answ = ""
    if (hour % 10 in 5..9 || hour in 10..20) {
        answ = "$hour часов назад"
    } else if (hour % 10 in 2..4) {
        answ = "$hour часа назад"
    } else if (hour % 10 == 1) {
        answ = "$hour час назад"
    }
    return answ
}