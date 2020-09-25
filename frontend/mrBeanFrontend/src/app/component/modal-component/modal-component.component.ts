import { Component, OnInit ,Optional, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-component',
  templateUrl: './modal-component.component.html',
  styleUrls: ['./modal-component.component.css']
})
export class ModalComponentComponent {

  constructor(public dialogRef: MatDialogRef<ModalComponentComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: any) { }

    performAction(): void {
      this.data.dop = new Date(this.data.dop).getTime()/1000;
      
      this.dialogRef.close({
        data: this.data
        
      });
    }

}
