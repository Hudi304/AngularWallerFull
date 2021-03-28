import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Currency } from '../model/currency';
import { Transaction } from '../model/transaction';

@Injectable()
export class AdminService {

  private adminsUrl: string;

  constructor(private http: HttpClient) {
    this.adminsUrl = 'http://localhost:8080/admin';
  }

  public fetchAllCurrencies(): Observable<Currency[]> {
    console.log("fetching all Currencies")
    return this.http.get<Currency[]>(this.adminsUrl + "/currencys")
  }

  public fetchAllTransactions(): Observable<Transaction[]> {
    console.log("fetching all transactions")
    return this.http.get<Transaction[]>(this.adminsUrl + "/transactions")
  }

  // public saveCurrencie(currencie: Currency){
  //   return this.http.post<>
  // }

  public saveTransaction(transaction:Transaction){
    return this.http.post(this.adminsUrl + "/transactions", transaction)
  }

  public saveCurrencie(currencie :  Currency){
    return this.http.post(this.adminsUrl + "/currencies", currencie)
  }

}
