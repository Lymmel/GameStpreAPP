package com.gmail.samuelhermosilla98.gamestoreapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Juego implements Parcelable {
    private Integer id;
    private String nombre;
    private Integer precio;
    private String fecha;
    private String imagen;

    public Juego() {
    }

    public Juego(Integer id, String nombre, Integer precio, String fecha, String imagen) {
        setId(id);
        setNombre(nombre);
        setPrecio(precio);
        setFecha(fecha);
        this.imagen = imagen;

    }

    public Juego(Parcel in){
        if(in.readByte()==0){
            id=null;
        }else{
            id=in.readInt();
        }
        nombre=in.readString();
        if(in.readByte()==0){
            precio=null;
        }else{
            precio=in.readInt();
        }
        fecha=in.readString();
        imagen=in.readString();
    }

    public Integer getId() {
        return id;
    }

    public boolean setId(Integer id) {
        if(id!=null){
            this.id = id;
            return true;
        }else{
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {

        if(nombre!=null){
            String stringPattern= "^[a-zA-Z ]*$";
            Pattern pattern = Pattern.compile(stringPattern);
            Matcher matcher = pattern.matcher(nombre);
            if (matcher.matches()) {
                this.nombre = nombre;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Integer getPrecio() {
        return precio;
    }

    public boolean setPrecio(Integer precio) {
        if(precio!=null){
            if (precio > 0) {
                this.precio = precio;

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getImagen() {
        return imagen;
    }

    public Boolean setImagen(String imagen) {
        if(imagen!=null){
            this.imagen = imagen;
            return true;
        }
        return false;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean setFecha(String fecha) {
        if (fecha != null) {
            String fecPattern="^((([0][1-9]|[12][0-9]|3[01])(\\/|\\-)([0][13-9]|[1][0-2]))|(([0][1-9]|[12][0-9])(\\/|\\-)02))(\\/|\\-)(\\d{4})";
            Pattern pattern = Pattern.compile(fecPattern);
            Matcher matcher = pattern.matcher(fecha);
            if (matcher.matches()) {
                this.fecha = fecha;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<Juego> CREATOR = new Creator<Juego>() {
        @Override
        public Juego createFromParcel(Parcel in) {
            return new Juego(in);
        }

        @Override
        public Juego[] newArray(int size) {
            return new Juego[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if(id==null){
            dest.writeByte((byte)0);
        }else{
            dest.writeByte((byte)1);
            dest.writeInt(id);
        }
        dest.writeString(nombre);
        if(id==null){
            dest.writeByte((byte)0);
        }else{
            dest.writeByte((byte)1);
            dest.writeInt(precio);
        }
        dest.writeString(fecha);
        dest.writeString(imagen);
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fecha='" + fecha + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
