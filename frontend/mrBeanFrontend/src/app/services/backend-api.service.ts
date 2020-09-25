import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment'
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BackendApiService {

  Server_URL=environment.Server_Url;
  constructor( private httpClient:HttpClient) { }

  public viewcars()
  {
    return this.httpClient.get<any>(this.Server_URL+"getcars");
  }

  public deletecar(uid)
  {
    return this.httpClient.post<any>(this.Server_URL+"deletecar/"+uid,"");
  }

  public filterprice(max,min)
  {
    return this.httpClient.post<any>(this.Server_URL+"getcarfilter/"+max+"/"+min,"");
  }

  public updatecar(form) {
    return this.httpClient.post<any>(`${this.Server_URL}/updatecar`, form);
  }

  public addcar(form) {
    return this.httpClient.post<any>(`${this.Server_URL}/addcar`, form);
  }


}
