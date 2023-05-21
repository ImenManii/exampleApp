import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
@Injectable({
    providedIn: 'root',
  })
  export class AccountService {
    private baseUrl = 'http://localhost:8080'; 
  
    constructor(private http: HttpClient) {}
  
    openAccount(accountInputData: any): Observable<any> {
      const url = `${this.baseUrl}/accounts`;
      return this.http.post(url, accountInputData);
    }
  
    getAccountDetails(customerId: string): Observable<any> {
      const url = `${this.baseUrl}/accounts/${customerId}`;
      return this.http.get(url);
    }
  }