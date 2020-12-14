MERGE INTO `role` VALUES (1,'USER');
MERGE INTO `role` VALUES (2,'ADMIN');
MERGE INTO `role` VALUES (3,'SADMIN');

MERGE into `product` values 
	(001, 
	'BooksRUS', 
	'Book',
	'NewsStand',
	'https://bigmedium.com/bm.pix/newsstand.jpg',
	'DUMMY',
	'XX',
	10.00,
	3);
MERGE into `product` values 
	(002, 
	'BooksRUS',
	'Book',
	'Best Selling Books',
	'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLxCdXca2-cPn3OHYl-4dw0CoDpbkEgT2Lvw&usqp=CAU',
	'DUMMY',
	'XX',
	30.00,
	6);	
MERGE into `product` values 
	(003, 
	'BooksRUS',
	'Book',
	'Non-fiction', 
	'https://study.com/cimages/videopreview/nonfiction_copy_133873.jpg',
	'DUMMY',
	'XX',
	7.34,
	2);
MERGE into `product` values 
	(004, 
	'BooksRUS',
	'EBook',
	'Read with Touch', 
	'https://blog.tcea.org/wp-content/uploads/2016/05/ipadreader-1.jpg',
	'DUMMY',
	'XX',
	30.00,
	6);
	
--USER_ID  	BRAND  	CATEGORY  	DESCRIPTION  	IMAGE_URL  	NAME  	PRICE  	QUANTITY  
