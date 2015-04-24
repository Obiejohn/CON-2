class ATM(val account: BankAccount, val user: String) {

  // if the account has funds to cover, take out a specific amount
  def withdrawal(amount: Int) = {
    println(user + " wants to withdraw $" + amount)
    println(user + " account balance = $" + account.balance)
    if (account.balance >= amount) {
      try {
        account.withdraw(amount)
        dispenseCash(amount)
      } catch {
        case ex: BankAccountLessThanZeroExcpetion =>
          println(ex.getMessage())
        case ex: IllegalArgumentException =>
          println(ex.getMessage())
      }

    } else {
      println(user + ", you have insufficient funds!")
    }

    println(user + " account balance = $" + account.balance)
  }

  // once funds are withdrawn from the account, the ATM provides 
  // the paper money to the user
  def dispenseCash(amount: Int) = {
    println(user + " receives $" + amount)
  }

  // add funds to the account
  def deposit(amount: Int) = {
    println(user + " wants to deposit $" + amount)
    println(user + " account balance = $" + account.balance)
    if (amount > 0) {
      acceptCash(amount)
      account.deposit(amount)
    } else {
      println(user + " can not deposit amounts <= 0")
    }

    println(user + " account balance = $" + account.balance)
  }

  // once a user has keyed in a deposit, the ATM allows the user to 
  // insert cash or checks
  def acceptCash(amount: Int) = {
    println(user + " deposits $" + amount)
  }

}