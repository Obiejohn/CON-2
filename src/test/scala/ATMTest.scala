import org.scalatest._
import Matchers._

class ATMTest extends FlatSpec with Matchers {

  behavior of "An ATM"

  it should "accept amounts > 0 for deposit" in {
    val account = new BankAccount(0)
    val ATM1 = new ATM(account, "Bob")
    ATM1.deposit(1000)
    assert(account.balance == 1000)
  }

  it should "not accept amounts <= 0 for deposit" in {
    val account = new BankAccount(0)
    val ATM1 = new ATM(account, "Bob")
    ATM1.deposit(0)
    assert(account.balance == 0)
    ATM1.deposit(-1)
    assert(account.balance == 0)
  }

  it should "dispense cash on withdrawal" in {
    val account = new BankAccount(0)
    val ATM1 = new ATM(account, "Bob")
    ATM1.deposit(1000)
    ATM1.withdrawal(900)
    assert(account.balance == 100)
  }

  it should "not dispense cash on withdrawal if the amount is more than the balance" in {
    val account = new BankAccount(0)
    val ATM1 = new ATM(account, "Bob")
    val start_balance = account.balance
    ATM1.withdrawal(account.balance + 1)
    assert(account.balance == start_balance)
  }

  it should "dispense cash on withdrawal if the amount is equal to the balance" in {
    val account = new BankAccount(1000)
    val ATM1 = new ATM(account, "Bob")
    val start_balance = account.balance
    ATM1.withdrawal(start_balance)
    assert(account.balance == 0)
  }

  it should "not dispense cash on withdrawal if the amount is <= 0 " in {
    val account = new BankAccount(10)
    val ATM1 = new ATM(account, "Bob")
    ATM1.deposit(0)
    assert(account.balance == 10)
    ATM1.deposit(-1)
    assert(account.balance == 10)
  }

}