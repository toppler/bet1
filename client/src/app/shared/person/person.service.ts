import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PersonService {
  public API = '//localhost:8080';
  public PERSON_API = this.API + '/persons';
  public PERSON_API_SAVE = this.API + '/save';

  constructor(private http: HttpClient) { }
  getAll():Observable<any>{
        return this.http.get(this.PERSON_API);
  }

  get(id: string) {
      return this.http.get(this.PERSON_API + '/' + id);
    }

    save(person: any): Observable<any> {
        let result: Observable<Object>;
        if (person['href']) {
          result = this.http.put(person.href, person);
        } else {
          result = this.http.post(this.PERSON_API_SAVE, person);
        }
        return result;
      }



  remove(href: string) {
    return this.http.delete(href);
  }

}
