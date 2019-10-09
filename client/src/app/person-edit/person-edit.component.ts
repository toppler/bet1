import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
 import { ActivatedRoute, Router } from '@angular/router';
import { PersonService } from '../shared/person/person.service';
import { GiphyService } from '../shared/glyphy/giphy.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-person-edit',
  templateUrl: './person-edit.component.html',
  styleUrls: ['./person-edit.component.css']
})
export class PersonEditComponent implements OnInit, OnDestroy {
    person: any ={};
    sub: Subscription;
    constructor(private route: ActivatedRoute,
                 private router: Router,
                 private personService: PersonService,
                 private giphyService: GiphyService) {
     }

  ngOnInit() {
     this.sub = this.route.params.subscribe(params => {
          const id = params['id'];
          if (id) {
            this.personService.get(id).subscribe((person: any) => {
              if (person) {
                this.person = person;
                this.person.href = person._links.self.href;
                this.giphyService.get(person.name).subscribe(url => person.giphyUrl = url);
              } else {
                console.log(`Car with id '${id}' not found, returning to list`);
                this.gotoList();
              }
            });
          }
        });
  }

  ngOnDestroy() {
      this.sub.unsubscribe();
    }

    gotoList() {
      this.router.navigate(['/person-list']);
    }

    save(form: NgForm) {
      this.personService.save(form).subscribe(result => {
        this.gotoList();
      }, error => console.error(error));
    }

    remove(href) {
      this.personService.remove(href).subscribe(result => {
        this.gotoList();
      }, error => console.error(error));
    }

}
