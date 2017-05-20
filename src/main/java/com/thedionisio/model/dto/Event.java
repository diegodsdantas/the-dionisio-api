package com.thedionisio.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thedionisio.model.bss.CompanyBss;
import com.thedionisio.util.mongo.Mongo;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class Event {


    @Override
    public String toString() {
        return "Event{" +
                "_id=" + _id +
                ", _idCompany=" + _idCompany +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateTimeControl=" + dateTimeControl +
                ", genres=" + genres +
                ", urlBanners=" + urlBanners +
                ", batches=" + batches +
                ", tickets=" + tickets +
                ", place=" + place +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public String _idCompany;
    public String name;
    public String description;
    public DateTimeControl dateTimeControl;
    public List<String> genres;
    public List<String> urlBanners;
    public List<Batch> batches;
    @JsonIgnore()
    public List<Ticket> tickets;
    public Place place;
    public Boolean isActive;


    @JsonIgnore
    public Event treatCreate(){
        this.isActive = true;
        return this;
    }

    @JsonIgnore()
    public String isRequered(){
        return " < _idCompany, _idPlace, name >";
    }

    @JsonIgnore()
    public Boolean createValidation(){
        System.out.println(new CompanyBss().isActiveCompany(this._idCompany));
        return  this.name!=null && new CompanyBss().isActiveCompany(this._idCompany);
    }

    @JsonIgnore()
    public String attributeIdentifier(){return "email < ";}

    @JsonIgnore()
    public Event treatResponse()
    {
        this._id = Mongo.treatMongoId.toString(this._id);
        return this;
    }

}
