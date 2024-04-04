import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  form!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.form = this.fb.group({
      nome: [null, Validators.required],
      cognome: [null, Validators.required],
      authData: this.fb.group(
        {
          email: [null, [Validators.required, Validators.email]],
          password: [null, Validators.required],
          passwordConfirm: [null, Validators.required],
        },
        { validators: this.passwordMatch }
      ),
    });
  }


  passwordMatch(g: FormGroup) {
    return g.get('password')!.value === g.get('passwordConfirm')!.value? null: { mismatch: true };
  }

  registerData() {
    if (this.form.valid) {
      console.log('Registrazione avvenuta con successo');
      console.log(`Nome: ${this.form.value.nome}`);
      console.log(`Cognome: ${this.form.value.cognome}`);
      console.log(`Email: ${this.form.value.authData.email}`);
      console.log(`Password: ${this.form.value.authData.password}`);

    } else {
      console.log('Form non valido');
    }
  }
}
