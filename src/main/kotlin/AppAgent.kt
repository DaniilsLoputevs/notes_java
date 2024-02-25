fun main() {
//    val deposit = 100
    val deposit = 700
//    println(getPercentValue(100, 150.0))
//    println(getPercentValue(200, 150.0))

    /* 100
     * initDeposit :         100
     * deposit :             114.0
     * comboTaskMaxAmount1 : 114.0 (usually : 100)
     * comboTaskMaxAmount2 : 173.565
     * comboTaskMaxAmount3 : 264.25271250000003
     * comboTaskMaxAmount4 : 402.3247547812501
     * comboTaskMaxAmount5 : 612.5394391544532
     * comboTaskMaxAmount6 : 932.5912961126551
     * sum                 : 2499.2732025483583
     */
    calculateComboTaskStepsAndMaxReserveAmount(100)
    calculateComboTaskStepsAndMaxReserveAmount(200)
    calculateComboTaskStepsAndMaxReserveAmount(700)
    calculateComboTaskStepsAndMaxReserveAmount( 484.05)
}

/**
 * Прим. 1 - начинаем с суммы Депозита что будет по окончанию сета, обычно под конец сета, мы имеем + 10-14% от суммы депозита.
 *      То есть, было 100, стало 114. Это делается для более точного расчёта ввиду того что Комбо-таски начинаются не с 1-ой таски в сете, а где-то в середине,
 *      то есть расчётных депозит будет выше из-за профита полученного за таски ранее выполненные в сете.
 * Прим. 2 - первая в серии комбо таска, будет под придет нынешнего deposit(реально может быть меньше, но точно около предела. Чаще всего это сумма Изначального депозита,
 *      а после submit на счету останется только profit)
 * Прим. 3 - хорошо если 2-ая серия комбо будет СРАЗУ после первой, этот код на это и расщитывает, в случаи если 2-ая серия будет с банком больше, то может быть хуже.
 */
fun calculateComboTaskStepsAndMaxReserveAmount(initDeposit: Number) {
    val comboTaskCommissionPercent: Double = 1.5
    val comboTaskAmountMaxMultiplierPercent: Double = 150.0
    val maxTotalProfitAsPercent: Double = 14.0
    var depositValueForNext = 0.0

    // прим 1
//    val deposit = initDeposit + getPercentValue(initDeposit, maxTotalProfitAsPercent)
    val deposit = initDeposit.toDouble()

    // прим 2
    val comboTaskMaxCost1 = deposit
    depositValueForNext = comboTaskMaxCost1 + getPercentValue(comboTaskMaxCost1, comboTaskCommissionPercent)

    val comboTaskMaxCost2 = getPercentValue(depositValueForNext, comboTaskAmountMaxMultiplierPercent)
    depositValueForNext = comboTaskMaxCost2 + getPercentValue(comboTaskMaxCost2, comboTaskCommissionPercent)

    val comboTaskMaxCost3 = getPercentValue(depositValueForNext, comboTaskAmountMaxMultiplierPercent)
    depositValueForNext = comboTaskMaxCost3 + getPercentValue(comboTaskMaxCost3, comboTaskCommissionPercent)

//    println("depositValueForNext : $depositValueForNext")
    println("initDeposit :         $initDeposit")
    println("deposit :             $deposit")
    println("comboTaskMaxCost1 : $comboTaskMaxCost1 (usually : $initDeposit)")
    println("comboTaskMaxCost2 : $comboTaskMaxCost2")
    println("comboTaskMaxCost3 : $comboTaskMaxCost3")


    val comboTaskMaxCost4 = getPercentValue(depositValueForNext, comboTaskAmountMaxMultiplierPercent)
    depositValueForNext = comboTaskMaxCost4 + getPercentValue(comboTaskMaxCost4, comboTaskCommissionPercent)

    val comboTaskMaxCost5 = getPercentValue(depositValueForNext, comboTaskAmountMaxMultiplierPercent)
    depositValueForNext = comboTaskMaxCost5 + getPercentValue(comboTaskMaxCost5, comboTaskCommissionPercent)

    val comboTaskMaxCost6 = getPercentValue(depositValueForNext, comboTaskAmountMaxMultiplierPercent)
    depositValueForNext = comboTaskMaxCost6 + getPercentValue(comboTaskMaxCost6, comboTaskCommissionPercent)

    val sumOfAllAmountComboTask = comboTaskMaxCost1 + comboTaskMaxCost2 + comboTaskMaxCost3 +
            comboTaskMaxCost4 + comboTaskMaxCost5 + comboTaskMaxCost6

    println("comboTaskMaxCost4 : $comboTaskMaxCost4")
    println("comboTaskMaxCost5 : $comboTaskMaxCost5")
    println("comboTaskMaxCost6 : $comboTaskMaxCost6")
    println("sum                 : $sumOfAllAmountComboTask")


}

/**
 * @param base: 200
 * @param percent: 150
 * @return 300
 */
//fun getPercentValue (base : Int, percent : Int) : Double {
//    return base * (percent.toDouble() / 100)
//}
fun getPercentValue(base: Number, percent: Double): Double {
    return base.toDouble() * (percent / 100)
}