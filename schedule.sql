CREATE TABLE `user` (
                        `userID`	INT	PRIMARY KEY,
                        `username`	VARCHAR(11)	NOT NULL,
                        `email`	VARCHAR(255)	NOT NULL,
                        `password`	VARCHAR(16)	NOT NULL,
                        `createdAt`	DATETIME	NOT NULL,
                        CONSTRAINT UQ_User UNIQUE (email, password)
);

CREATE TABLE `schedule` (
                            `scheduleID`	INT	PRIMARY KEY	AUTO_INCREMENT,
                            `userID`	INT	NOT NULL,
                            `title`	VARCHAR(51)	NOT NULL,
                            `content`	VARCHAR(255)	NOT NULL,
                            `createdAt`	DATETIME	NOT NULL,
                            `updatedAt`	DATETIME	NOT NULL,
                            FOREIGN KEY(userID) REFERENCES user(userID)
);

CREATE TABLE `comment` (
                           `commentID`	INT	PRIMARY KEY	AUTO_INCREMENT,
                           `content`	VARCHAR(255)	NOT NULL,
                           `createdAt`	DATETIME	NOT NULL,
                           `updatedAt`	DATETIME	NOT NULL,
                           `userID`	INT	NOT NULL,
                           `scheduleID`	INT	NOT NULL,
                           FOREIGN KEY(userID) REFERENCES user(userID),
                           FOREIGN KEY(scheduleID) REFERENCES schedule(scheduleID)
);
