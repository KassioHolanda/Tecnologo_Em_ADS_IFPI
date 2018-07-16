var savingsAccount = {
    balance: 1000,
    interestRatePercent: 1,
    deposit: function addMoney(amount) {
        if (amount > 0) {
            savingsAccount.balance += amount;
        }
    },
    withdraw: function removeMoney(amount) {
        var verifyBalance = savingsAccount.balance - amount;
        if (amount > 0 && verifyBalance >= 0) {
            savingsAccount.balance -= amount;
        }
    },

    account: function printAccountSummary() {
        return 'Welcome\nYour balance is currently $' + this.balance + ' and your interest rate is ' + this.interestRatePercent + '%.'
    }
};

// savingsAccount.deposit(40);
// savingsAccount.interestRatePercent = 2;
// console.log(savingsAccount.account());


function testaConta(acc) {
    acc.balance = 100;
    acc.interestRatePercent = 3;
    acc.deposit(130);
    acc.deposit(50);
    return (acc.account() == 'Welcome\nYour balance is currently $280 and your interest rate is 3%.');
}


console.log(testaConta(savingsAccount));

