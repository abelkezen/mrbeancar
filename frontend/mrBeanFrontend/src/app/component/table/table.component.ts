import { Component, OnInit,ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import { MatTable } from '@angular/material';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {BackendApiService} from "../../services/backend-api.service"
import { MatDialog } from '@angular/material/dialog';
import { ModalComponentComponent } from '../modal-component/modal-component.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  table_data;
  min;
  max;
  displayedColumns: string[] = ['company','model','color','dateofpurchase','price','enginecapacity','licenseplateno','seatingcapacity','Button'];
  @ViewChild(MatTable,{static:true}) table: MatTable<any>;
  @ViewChild('envPaginator', {static: true,read: MatPaginator}) envPaginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  table_data1;

  constructor(public dialog: MatDialog,private backendservice :BackendApiService) { }
  
  ngOnInit() {

    this.getdata();
      

    
  }

  performAction()
  {

    this.backendservice.filterprice(this.max,this.min).subscribe(
      data =>
      {
        data.forEach(element => {
          element.date = new Date(element.dop*1000).toString().substring(4,15);

          element.dop = new Date(element.dop*1000)
          element.dop = element.dop.toISOString().split('T')[0]
          
        });
        this.table_data1 = data;
        this.table_data=new MatTableDataSource(this.table_data1); 
        this.table_data.paginator=this.envPaginator;
        this.table_data.sort = this.sort;
      },
      error=>
      {

      }
    );

  }

  openDialog(type,i): void {
    if(type == "add")
    {
      let temp={};
      temp["type"] = "ADD"
    const dialogRef = this.dialog.open(ModalComponentComponent, {
      width: '700px',
      data:temp
    });

    dialogRef.afterClosed().subscribe(result => {
      {
        let data = result.data;
        this.backendservice.addcar(data).subscribe(data =>
          {
            this.getdata();
          },
          error=>
          {
            this.getdata();
          }
        );
      }
    
    });
  }
  else{
    let temp = this.table_data1[i];
    temp["type"] = "UPDATE"
    const dialogRef = this.dialog.open(ModalComponentComponent, {
      width: '700px',
      data: temp
    });

    dialogRef.afterClosed().subscribe(result => {
      {
        let data = result.data;
        this.backendservice.updatecar(data).subscribe(data =>
          {
            this.getdata();
          },
          error=>
          {
            this.getdata();
          }
        );
      }
    });
  }
  }


  getdata()
  {
    this.backendservice.viewcars().subscribe(
      data =>
      {
        data.forEach(element => {
          element.date = new Date(element.dop*1000).toString().substring(4,15);

          element.dop = new Date(element.dop*1000)
          element.dop = element.dop.toISOString().split('T')[0]
          
        });
        this.table_data1 = data;
        this.table_data=new MatTableDataSource(this.table_data1); 
        this.table_data.paginator=this.envPaginator;
        this.table_data.sort = this.sort;
      },
      error=>
      {

      }
    );
  }

  applyFilter(filterValue: string) {
    this.table_data.filter = filterValue.trim().toLowerCase();
    if (this.table_data.paginator) {
      this.table_data.paginator.firstPage();
    }
    }

    delete(uid){
      if(confirm("Sure Want to Delete This Entry?"))
      {
        this.backendservice.deletecar(uid).subscribe(data =>
          {
            this.getdata();
          },
          error=>
          {
            this.getdata();
          }
        );
      }
      
    }

}
