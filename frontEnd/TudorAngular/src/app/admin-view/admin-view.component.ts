import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Currency } from '../model/currency';
import { Transaction } from '../model/transaction';
import { AdminService } from '../service/admin.service';
import { User } from '../user';
import { UserService } from '../user-service.service';


@Component({
  selector: 'app-admin-view',
  templateUrl: './admin-view.component.html',
  styleUrls: ['./admin-view.component.css']
})
export class AdminViewComponent implements OnInit {

  showFiller: boolean = false;

  users: User[] = [];
  oldUser: User;
  newUser: User;

  
  currencies: Currency[] = [];
  oldcurrencie : Currency;
  newcurrencie : Currency;

  transactions: Transaction[] = [];
  oldTransaction: Transaction;
  newTransaction: Transaction;

  tabs = ['First', 'Second', 'Third'];
  selected = new FormControl(0);

  constructor(private userService: UserService,
    private adminService: AdminService) {
    this.oldUser = new User();
    this.newUser = new User();
    this.oldcurrencie =  new Currency();
    this.newcurrencie =  new Currency();
    this.oldTransaction =  new Transaction();
    this.newTransaction =  new Transaction();
  }

  ngOnInit(): void {
    this.refreshUsersTable();
    this.refreshCurrencysTable();
    this.refreshTransactionsTable();
    //console.log(this.curerncyes)
  }

  refreshUsersTable(): void {
    this.userService.findAll()
      .subscribe(data => {
        this.users = data;
      })
  }

  refreshCurrencysTable(): void {
    this.adminService.fetchAllCurrencies()
      .subscribe(data => {
        this.currencies = data
        console.log(this.currencies)
      })
  }

  refreshTransactionsTable(): void {
    this.adminService.fetchAllTransactions()
      .subscribe(data => {
        this.transactions = data
        console.log(this.transactions)
      })
  }

  removeUser(nickname: string) {
    this.userService.delete(nickname)
      .subscribe(data => {
        this.refreshUsersTable()
      })
  }

  onUserUpdate(user: User) {
    this.oldUser = user
  }
  onCurrencieUpdate(currencie : Currency ){
    this.oldcurrencie = currencie
  }
  onTransactionUpdate(tranaction : Transaction){
    this.oldTransaction =  tranaction
  }
  saveUserAndRefresh() {
    this.userService.save(this.newUser)
      .subscribe(data => {
        this.refreshUsersTable()
      })
  }
  saveCurrencieAndRefresh() {
    this.adminService.saveCurrencie(this.newcurrencie)
      .subscribe(data => {
        this.refreshCurrencysTable()
      })
  }
  saveTransitionAndRefresh() {
    this.adminService.saveTransaction(this.newTransaction)
      .subscribe(data => {
        this.refreshTransactionsTable()
      })
  }

  updateUserAndRefresh(){
    
  }
  
  updateCurrencieAndRefresh(){

  }

  updateTransactionAndRefresh(){
    
  }

 

  removeCurrencie(name : string){
  }

  removeTransaction(id : number){
  }
 




}
