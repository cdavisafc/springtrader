/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.nanotrader.data.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "quote")
public class Quote implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	//@GeneratedValue(generator="randomId")
    //@GenericGenerator(name="randomId", strategy="hdb.RandomIdGenerator")
    @Column(name = "quoteid")
    private Integer quoteid;

	public Integer getQuoteid() {
        return this.quoteid;
    }

	public void setQuoteid(Integer id) {
        this.quoteid = id;
    }

	//@Column(name = "low", precision = 14, scale = 2)
	@Column(name = "low")
    //private BigDecimal low;
	private double db_low;

	//@Column(name = "open1", precision = 14, scale = 2)
	@Column(name = "open1")
	//private BigDecimal open1;
	private double db_open1;

	@Column(name = "volume")
    @NotNull
    //private BigDecimal volume;
    private double db_volume;

	//@Column(name = "price", precision = 14, scale = 2)
	@Column(name = "price")
    //private BigDecimal price;
	private double db_price;

	//@Column(name = "high", precision = 14, scale = 2)
	@Column(name = "high")
    //private BigDecimal high;
	private double db_high;

	@Column(name = "companyname", length = 250)
    private String companyname;

	@Column(name = "symbol", length = 250)
    @NotNull
    private String symbol;

	@Column(name = "change1")
    @NotNull
    //private BigDecimal change1;
    private double db_change1;
	
    @Column(name = "version")
    private int version = 0;

	/* ------------- */
	public double getDb_low() {
        return this.db_low;
    }

	public void setDb_low(double db_low) {
        this.db_low = db_low;
    }
	
	public BigDecimal getLow() {
        return BigDecimal.valueOf(db_low);
    }

	public void setLow(BigDecimal low) {
        this.db_low = low.doubleValue();
    }
	/* ------------- */

	/* ------------- */
	public double getDb_open1() {
        return this.db_open1;
    }

	public void setDb_open1(double db_open1) {
        this.db_open1 = db_open1;
    }
	
	public BigDecimal getOpen1() {
        return BigDecimal.valueOf(db_open1);
    }

	public void setOpen1(BigDecimal open1) {
        this.db_open1 = open1.doubleValue();
    }
	/* ------------- */
	
	/* ------------- */
	public double getDb_volume() {
        return this.db_volume;
    }

	public void setDb_volume(double db_volume) {
        this.db_volume = db_volume;
    }
	
	public BigDecimal getVolume() {
        return BigDecimal.valueOf(db_volume);
    }

	public void setVolume(BigDecimal volume) {
        this.db_volume = volume.doubleValue();
    }
	/* ------------- */
	
	/* ------------- */
	public double getDb_price() {
        return this.db_price;
    }

	public void setDb_price(double db_price) {
        this.db_price = db_price;
    }
	
	public BigDecimal getPrice() {
        return BigDecimal.valueOf(db_price);
    }

	public void setPrice(BigDecimal price) {
        this.db_price = price.doubleValue();
    }
	/* ------------- */
	
	/* ------------- */
	public double getDb_high() {
        return this.db_high;
    }

	public void setDb_high(double db_high) {
        this.db_high = db_high;
    }
	
	public BigDecimal getHigh() {
        return BigDecimal.valueOf(db_high);
    }

	public void setHigh(BigDecimal high) {
        this.db_high = high.doubleValue();
    }
	/* ------------- */

	public String getCompanyname() {
        return companyname;
    }

	public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

	public String getSymbol() {
        return symbol;
    }

	public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

	/* ------------- */
	public double getDb_change1() {
        return this.db_change1;
    }

	public void setDb_change1(double db_change1) {
        this.db_change1 = db_change1;
    }
	
	public BigDecimal getChange1() {
        return BigDecimal.valueOf(db_change1);
    }

	public void setChange1(BigDecimal change1) {
        this.db_change1 = change1.doubleValue();
    }
	/* ------------- */
	
	public int getVersion() {
        return version;
    }

	@Override
	public String toString() {
		return "Quote [quoteid=" + quoteid + ", low=" + db_low + ", open1=" + db_open1 + ", volume=" + db_volume + ", price="
				+ db_price + ", high=" + db_high + ", companyname=" + companyname + ", symbol=" + symbol + ", change1="
				+ db_change1 + ", version=" + version + "]";
	}
}
