CREATE SEQUENCE id_sequence START WITH 1 INCREMENT BY 1;

Create sequence  item_sequence Start with 1 increment by 1;

ALTER TABLE ITEM_TABLE,
ADD CONSTRAINT FK_ITEM_TABLE_MEMBER_TABLE,
FOREIGN KEY(id),
REFERENCES member_table(id);

