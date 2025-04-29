Mybatis Spring Example
============

## Database Design (Oracle)

	sqlplus scott/TIGER
	
	create table wordcard (
	word varchar2(45),
	definitions varchar2(4000),
	constraint pk_wordcard primary key(word)
	);
		
	create table photo (
	no number,
	content varchar2(4000),
	constraint pk_photo primary key(no)
	);

	create sequence seq_photo
	increment by 1
	start with 1
	;

## How to run

run $ **mvn jetty:run**