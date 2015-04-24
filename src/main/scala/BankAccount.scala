/**
 * A class that represents a bank account. The balance is stored as an Int
 * representing a number of dollars.
 *
 */
class BankAccount(private var bal: Int = 0) {
  if (bal < 0) throw new BankAccountLessThanZeroExcpetion

  def balance: Int = bal

  def deposit(amount: Int) = {
    if (amount <= 0) throw new IllegalArgumentException("deposit of " + amount + "is < 0")
    Thread.sleep(10) //arbitrary delay 
    val oldBalance = balance
    val newBalance = oldBalance + amount
    bal = newBalance
    if (bal < 0) throw new BankAccountLessThanZeroExcpetion
  }

  def withdraw(amount: Int) = {
    if (amount <= 0) throw new IllegalArgumentException("withdrawal of " + amount + " is <= 0")
    if (amount > bal) throw new IllegalArgumentException("withdrawal of " + amount + " exceeds balance")

    Thread.sleep(10) //arbitrary delay
    val oldBalance = balance
    val newBalance = oldBalance - amount
    bal = newBalance
    //post-condition??
    if (bal < 0) throw new BankAccountLessThanZeroExcpetion
  }
}

class BankAccountLessThanZeroExcpetion extends Exception("balance < 0") {
}