import org.scalatest._
import Matchers._

class BankAccountTest extends FlatSpec with Matchers {

  behavior of "A BankAccount"

  it should "allow creation of a 0 balance account" in {
    val account = new BankAccount(0)
    assert(account.balance == 0)
  }

  it should "allow creation of an account with balance > 0" in {
    val account = new BankAccount(1)
    assert(account.balance == 1)
  }

  it should "produce BankAccountLessThanZeroExcpetion if created with balance < 0" in {
    intercept[BankAccountLessThanZeroExcpetion] {
      val account = new BankAccount(-1)
    }
  }

  it should "accept funds > 0 for deposit" in {
    val account = new BankAccount(0)
    account.deposit(10)
    assert(account.balance == 10)
  }

  it should "produce IllegalArgumentException if deposit amount is 0, leaving balance unchanged" in {
    val account = new BankAccount(0)
    intercept[IllegalArgumentException] {
      account.deposit(0)
    }
    assert(account.balance == 0)
  }

  it should "produce IllegalArgumentException if deposit amount is < 0, leaving balance unchanged" in {
    val account = new BankAccount(0)
    intercept[IllegalArgumentException] {
      account.deposit(-1)
    }
    assert(account.balance == 0)
  }

  it should "allow withdrawal of amounts > 0" in {
    val account = new BankAccount(10)
    account.withdraw(10)
    assert(account.balance == 0)
  }

  it should "produce IllegalArgumentException if withdrawal amount is < 0, leaving balance unchanged" in {
    val account = new BankAccount(0)
    intercept[IllegalArgumentException] {
      account.withdraw(-1)
    }
    assert(account.balance == 0)
  }

  it should "produce IllegalArgumentException if withdrawal amount is 0, leaving balance unchanged" in {
    val account = new BankAccount(0)
    intercept[IllegalArgumentException] {
      account.withdraw(0)
    }
    assert(account.balance == 0)
  }

  it should "produce IllegalArgumentException if withdrawal is greater than balance, leaving balance unchanged" in {
    val account = new BankAccount(1)
    intercept[IllegalArgumentException] {
      account.withdraw(2)
    }
    assert(account.balance == 1)
  }

}