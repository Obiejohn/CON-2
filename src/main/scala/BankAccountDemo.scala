/**
 * Demonstrates several objects sequentially accessing shared mutable state.
 *
 * .
 */
object BankAccountDemo extends App {

  //create a checking account with $1000
  var checking = new BankAccount(1000)

  var ATM1 = new ATM(checking, "Bob")
  ATM1.withdrawal(10)
  ATM1.deposit(100)
  ATM1.withdrawal(1000)

  var ATM2 = new ATM(checking, "Sue")
  ATM2.withdrawal(10)
  ATM2.deposit(100)
  ATM2.withdrawal(1000)

}