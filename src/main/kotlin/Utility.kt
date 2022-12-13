import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.int
import java.time.LocalDate

object Utility : CliktCommand() {

  private val startDateArg by argument("start date")
  private val price by argument("monthly fee").int()
  private val exitDateArg by argument("exit date")

  override fun run() {
    val start = LocalDate.parse(startDateArg)
    val monthlyPaymentDay = if (start.dayOfMonth > 28) 28 else start.dayOfMonth
    val exit = LocalDate.parse(exitDateArg)
    var totalSum = 0
    start.datesUntil(exit).toList().forEach {
      if(it.dayOfMonth == monthlyPaymentDay) {
        totalSum += price
      }
    }
    echo(totalSum)
  }
}