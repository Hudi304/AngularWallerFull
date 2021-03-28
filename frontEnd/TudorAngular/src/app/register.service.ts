import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterRequest } from './register-request';
import { Observable } from 'rxjs';
import { RegisterResponse } from './register-response';
import { Pipe, PipeTransform } from '@angular/core';

@Injectable()
export class RegisterService {



  private userUrl: string;
  public registerResponse: RegisterResponse;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8080/register';
    this.registerResponse = new RegisterResponse();
  }



  public requestRegister(registerReq: RegisterRequest): Observable<RegisterResponse> {
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      observe: 'response' as 'response'
    };

    return this.http.post<RegisterResponse>(this.userUrl, registerReq)

  }

}
