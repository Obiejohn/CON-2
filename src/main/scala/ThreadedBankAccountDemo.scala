/**
 * Demonstrates several objects concurrently accessing shared mutable state.
 * 
 * Two Threads with separate ATMs access the same BankAccount.
 */
object ThreadedBankAccountDemo extends App {

  //create a checking account with $1000
  var checking = new BankAccount(1000)

  //thread for Bob
  val bobThread = new Thread {
    override def run {
      var ATM1 = new ATM(checking, "Bob")
      ATM1.withdrawal(10)
      ATM1.deposit(100)
      ATM1.withdrawal(1000)
    }
  }

  //thread for Sue
  val sueThread = new Thread {
    override def run {
      var ATM2 = new ATM(checking, "Sue")
      ATM2.withdrawal(10)
      ATM2.deposit(100)
      ATM2.withdrawal(1000)
    }
  }

  bobThread.start()
  
  sueThread.start()
  
}