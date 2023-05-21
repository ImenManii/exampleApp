import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AccountService } from '../../services/api/Account.service';
import { AccountInputData } from '../../services/inputs/CustomerInputData';
import { Subject } from 'rxjs';
import { finalize, takeUntil, take, filter } from 'rxjs/operators';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  accountForm!: FormGroup;
  accountCreated = false;
  result: any;
  accountDetails: any;
  destroy: Subject<boolean> = new Subject<boolean>();
  isButtonClicked = false;
  constructor(private formBuilder: FormBuilder,
    private accountService: AccountService) {
    this.accountForm = this.createAccountForm();
  }

  ngOnInit(): void {
  }

  createAccountForm(): FormGroup {
    return this.formBuilder.group({
      customerID: ['', Validators.required],
      name: ['', Validators.required],
      surname: ['', Validators.required],
      initialCredit: [0, Validators.required]
    });
  }

  openNewAccount() {
    this.isButtonClicked = true;
    if (this.accountForm.valid) {
      const accountInputData: AccountInputData = {
        customerId: this.accountForm ?.get('customerID') ?.value,
        initialCredit: this.accountForm ?.get('initialCredit') ?.value,
        name: this.accountForm ?.get('name') ?.value,
        surname: this.accountForm ?.get('surname') ?.value
    };
      this.accountService.openAccount(accountInputData)
        .pipe(take(1), takeUntil(this.destroy), finalize(() => { }))
        .subscribe((data: any) => {
          this.result = data;
          this.accountCreated = true;
          this.getAccountDetails(data)
          this.accountForm.reset();
          this.isButtonClicked = false;
        }, (Error: any) => { },
          () => {
          });
    }
  }

  getAccountDetails(customerId: any) {
    this.accountService.getAccountDetails(customerId)
      .pipe(take(1), takeUntil(this.destroy), finalize(() => {
      }))
      .subscribe((data: any) => {
        this.accountDetails = data;
      }, (Error: any) => { },
        () => {
        });
  }

  reset(){
    this.accountCreated = false;
    this.accountForm.reset();
  }

  ngOnDestroy(): void {
    this.destroy.next(true);
    this.destroy.unsubscribe();
  }

}
