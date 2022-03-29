
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

// Structures
typedef struct user {

	char address[40];
	struct mailServer *server;
	struct mail *inbox;    	 		// When adding mails, utilize memory allocation.
	struct user *next;		 		// Pointer to next user. For linked list purposes. When adding users, utilize memory allocation.

} user_t;

typedef struct mail {

	struct user *sender;
	char header[3][50];  	 		// Receiver address, subject (max 50 chars), and date.
	char content[300];   	 		// Max. 300 characters.
	struct mail *next;	 	 		// Linked list of mails in an inbox. (Extra feature)

} mail_t;

typedef struct mailServer {

	char domain[20];     	 	 	// Add following domains to main: {"ku.edu.tr", "gmail.com", "homeland.gov.us"}
	struct user *usersList;			// List of users.

} mailServer_t;


// Function Prototypes
void caesarEncrypt(int key, char *content);
void caesarDecrypt(int key, char *content);
// int subjectValidation(mail_t *mail);
void sendEmail(mailServer_t *server1, mailServer_t *server2, mailServer_t *server3);
void addMail(mail_t *mail, user_t *receiver);
void displayMail(mail_t *mail);
void displayLastFive(user_t *user);
void searchKeyword(user_t *user, char *keyword);
void createUser(char *address, mailServer_t *server);
void createServer(mailServer_t *server, char *domain);
void addHardCodedMail(user_t *sender, user_t *receiver, char *subject, char *date, char *content, int key);

// Main
int main() {

	//	Create Servers (Hard Coded).
	mailServer_t *ku = (mailServer_t *) malloc(sizeof(mailServer_t));
	mailServer_t *gmail = (mailServer_t *) malloc(sizeof(mailServer_t));
	mailServer_t *homeland = (mailServer_t *) malloc(sizeof(mailServer_t));

	createServer(ku, "ku.edu.tr");
	createServer(gmail, "gmail.com");
	createServer(homeland, "homeland.gov.us");

	printf("All Servers Created.\n\n");

	//	Create Users, Populate Servers.
	createUser("kgirenes18@ku.edu.tr", ku);
	createUser("osayar18@ku.edu.tr", ku);
	createUser("oozturk20@ku.edu.tr", ku);

	createUser("cbogac@gmail.com", gmail);
	createUser("flykerem@gmail.com", gmail);
	createUser("logitech@gmail.com", gmail);

	createUser("mholloway@homeland.gov.us", homeland);
	createUser("knewlands@homeland.gov.us", homeland);
	createUser("gadams@homeland.gov.us", homeland);

	printf("All Users Created.\n\n");

	// Add 5 hard coded mails to one user (kgirenes18@ku.edu.tr).
	printf("\nDisplaying last 5 mails of kgirenes18@ku.edu.tr\n");
	addHardCodedMail(ku->usersList->next, ku->usersList, "Hello Dear", "07.01.2021", "Hi dear, How are you?", 2);
	addHardCodedMail(ku->usersList->next->next, ku->usersList, "Hi Friend", "09.01.2021", "I miss you. Let's Hangout.", 2);
	addHardCodedMail(gmail->usersList, ku->usersList, "My Final Grades", "12.01.2021", "Can I talk with you about my final grades?", 2);
	addHardCodedMail(gmail->usersList->next->next, ku->usersList, "Mx Master 3", "15.01.2021", "Would you be interested in our latest product?", 2);
	addHardCodedMail(homeland->usersList->next, ku->usersList, "Dear Girenes", "03.01.2021", "You have to renew your residence permit.", 2);

	// Display the latest 5 mails of kgirenes18@ku.edu.tr.
	displayLastFive(ku->usersList);

	// Send Mail Here.
	printf("\n\nHere is the tricky part. Let's send an email.");
	printf("\n\n");
	sendEmail(ku, gmail, homeland);

	// Look for keyword here.
	printf("\n\nNow please enter a keyword. I'll go through Kerem's inbox: ");
	char keyword[50];
	scanf("%s", keyword);
	searchKeyword(ku->usersList, keyword);

	printf("\n\nTest ended. Commencing Shutdown.");

	return 0;
}


// Function Bodies
/*
 * This function encrypts the given content with the encryption key.
 *
 * @param	key			Encryption key.
 * @param	content		Content to be encrypted.
 */
void caesarEncrypt(int key, char *content) {
	int i;
	char c;
	int length = strlen(content);
	char text[length];
	strcpy(text, content);
	for(i=0; i<length; i++) {
		c = text[i];
		if(c >= 'a' && c <= 'z') {
			c = c + key;
			if(c > 'z') {
				c = c - 'z' + 'a' - 1;
			}
			text[i] = c;
		} else if (c >= 'A' && c <= 'Z') {
			c = c + key;
			if(c > 'Z') {
				c = c - 'Z' + 'A' - 1;
			}
			text[i] = c;
		}
	}
	strcpy(content, text);
}

/*
 * This function decrypts the given content with the decryption key.
 *
 * @param	key			Decryption key.
 * @param	content		Content to be decrypted.
 */
void caesarDecrypt(int key, char *content) {
	int i;
	char c;
	int length = strlen(content);
	char text[length];
	strcpy(text, content);
	for(i=0; i<length; i++) {
		c = text[i];
		if(c >= 'a' && c <= 'z') {
			c = c - key;
			if(c < 'a') {
				c = c + 'z' - 'a' + 1;
			}
			text[i] = c;
		} else if (c >= 'A' && c <= 'Z') {
			c = c - key;
			if(c < 'A') {
				c = c + 'Z' - 'A' + 1;
			}
			text[i] = c;
		}
	}
	strcpy(content, text);
}

/*
 * This function checks the validity of the mail.
 *
 * @param	mail	The mail to check its subjects validity.
 * @return	valid	Validity of the subject.
 *//*
int subjectValidation(mail_t *mail) {
	int valid=1, i, j;
	char sub[50];
	strcpy(sub, mail->header[1]);
	int sublen = strlen(sub);
	char arth[6] = {'+', '-', '*', '/', '%', '\0'};

	for(i=0; i<sublen; i++) {
		while(valid) {
			for(j=0; j<5; j++){
				if(isalpha(sub[i]) && sub[i+1]==arth[j]) {
					valid = 0;
				}
				if(sub[i]==arth[j] && isalpha(sub[i+1])) {
					valid = 0;
				}
			}
		}
	}

	return valid;
}
*/

/*
 * This is the function to construct an email based on user inputs.
 *
 * @param	server1, server2, server3	Servers to go through
 */
void sendEmail(mailServer_t *server1, mailServer_t *server2, mailServer_t *server3) {

	mail_t *mail = malloc(sizeof(mail_t));
	if(mail == NULL) {
		printf("\nMemory allocation failed.\n");
		return;						// If memory allocation fails, function returns. (Conventional use)
	}

	user_t *receiver;

	char senderInput[40];
	char receiverInput[40];

	printf("\nFrom: ");
	scanf("%s", senderInput);
	fflush(stdout);

	printf("\nTo: ");
	scanf("%s", receiverInput);
	fflush(stdout);

	// Check if receiverInput exists, then set the pointer "receiver" to point to that receiver.
	// In this part, we will PARSE the domain, and then go through the users in that mail server to find THE RECIPIENT.
	int lenReceiver = strlen(receiverInput), i, j, k=0;
	char at = '@';
	char domainRec[40];
	strcpy(domainRec, "");
	for(i=0; i<lenReceiver; i++) {
		if(receiverInput[i] == at) {
			for(j=i+1; j<lenReceiver; j++) {			// Starting from the character after '@'.
				domainRec[k] = receiverInput[j];
				k++;
			}
			break;
		}
	}													// We now have the domain name.
	mailServer_t *serverPtr;							// From now on, we try to find if such domain exists.
	int serverFound = 0;
	if(strcmp(domainRec, server1->domain) == 0) {
		serverPtr = server1;
		serverFound = 1;
	} else if(strcmp(domainRec, server2->domain) == 0) {
		serverPtr = server2;
		serverFound = 1;
	} else if(strcmp(domainRec, server3->domain) == 0) {
		serverPtr = server3;
		serverFound = 1;
	} else {
		printf("\nDomain doesn't exist. Send Mail failed.\n");
		return;
	}
	if(serverFound) {
		user_t *targetPtr = serverPtr->usersList;		// From now on, we try to see if such address exists.
		int addressFound = 0;
		while(targetPtr != NULL) {
			if(strcmp(receiverInput, targetPtr->address) == 0) {
				addressFound = 1;
				break;
			}
			targetPtr = targetPtr->next;
		}
		if(addressFound) {
			receiver = targetPtr;						// Here, we assign the found user to the receiver pointer.
			printf("Domain parsed. Receiver address is valid.\n");
			strcpy(mail->header[0], receiver->address);
		} else {
			printf("\nReceiver address not valid. Send Mail failed.\n");
			return;
		}
	}


	printf("\nSubject: ");
	char sub[50];
	scanf("%s", sub);
	fflush(stdout);
	strcpy(mail->header[1], sub);
	printf("\nSubject is Valid.\n");

	printf("\nEnter Date: ");
	char date[50];
	scanf("%s", date);
	fflush(stdout);
	strcpy(mail->header[2], date);
	fflush(stdin);

	printf("\nType your mail content (Max. 300 characters): ");
	char content[300];
	fgets(content, 300, stdin);
	fgets(content, 300, stdin);
	fflush(stdout);

	printf("\n\nProvide Encryption Key:	");
	int key;
	scanf("%d", &key);
	fflush(stdout);
	caesarEncrypt(key, content);

	strcpy(mail->content, content);

	addMail(mail, receiver);

	printf("\n\nSent Mail with the following properties:");
	printf("\nSender: %s", senderInput);
	printf("\nReceiver: %s", receiver->address);
	printf("\nSubject: %s", mail->header[1]);
	printf("\nDate: %s", mail->header[2]);
	printf("\nEncrypted Mail Content: %s", mail->content);
}

/*
 * Adds the mail to receiver's inbox.
 *
 * @param	mail		Mail pointer to the mail to be added
 * @param	receiver	User pointer to the owner of the inbox to which the mail will be added
 */
void addMail(mail_t *mail, user_t *receiver) {

	mail_t *current = receiver->inbox;
	while (current->next != NULL) {
		current = current->next;
	}
	current->next = mail;
	mail->next = NULL;

}

/*
 * Displays the decrypted content of the given mail.
 *
 * @param	mail	Mail to be displayed
 */
void displayMail(mail_t *mail) {

	int key;
	printf("\n\nPlease Provide The Decryption Key: ");
	scanf("%d", &key);
	fflush(stdout);
	printf("\n\nFrom: %s", mail->sender->address);
	printf("\nTo: %s", mail->header[0]);
	printf("\nSubject: %s", mail->header[1]);
	printf("\nDate: %s", mail->header[2]);
	printf("\nEncrypted Content: %s", mail->content);
	char toBeDisplayed[300];
	strcpy(toBeDisplayed, mail->content);
	caesarDecrypt(key, toBeDisplayed);
	printf("\nDecrypted Content: %s", toBeDisplayed);

}

/*
 * Displays the last five mails of the given user.
 *
 * @param	user	User whose 5 mails will be displayed.
 */
void displayLastFive(user_t *user) {

	mail_t *current = user->inbox;
	while(current->next != NULL) {
		if(current->next->next->next->next->next == NULL) {			// Stop if we have 5 mails left.
			for(int i=0; i<5; i++) {
				displayMail(current);
				current = current->next;
			}
			return;
		}
		current = current->next;	// Go towards the end of the inbox.
	}

}

/*
 * This function searches the given keyword among the mail headers of mails
 * in the given user's inbox, and then prints them.
 *
 * @param	user	User whose inbox will be searched through.
 * @param	keyword	Keyword to be searched in the user's inbox.
 */
void searchKeyword(user_t *user, char *keyword) {

	mail_t *current = user->inbox;
	char element[50];					// Elements of header.
	int check=0;
	printf("\n\nDisplaying mails with the word %s in their header:\n\n", keyword);
	while(current != NULL) {
		// Search for keyword.
		for(int i=0; i<3; i++) {
			strcpy(element, current->header[i]);
			if(strstr(element, keyword) != NULL) {
				check=1;
			}
		}
		if(check) {
			// Print header elements here.
			printf("To: %s\n", current->header[0]);
			printf("Subject: %s\n", current->header[1]);
			printf("Date: %s\n\n", current->header[2]);
		}
		current = current->next;
		check=0;
	}

}

/*
 * Creates user with given address, adds it to server's user linked list.
 *
 * @param	address	Mail address of the user.
 * @param	server	Server which the user will be added to.
 */
void createUser(char *address, mailServer_t *server) {

	user_t *current = server->usersList;

	while(current->next != NULL) {
		current = current->next;
	}

	strcpy(current->address, address);
	current->server = server;
	current->inbox = (mail_t *) malloc(sizeof(mail_t));

	current->next = (user_t *) malloc(sizeof(user_t));

}

/*
 * Creates server with given domain name.
 *
 * @param	server	Server pointer.
 * @param	domain	Domain name of the server.
 */
void createServer(mailServer_t *server, char *domain) {

	strcpy(server->domain, domain);
	server->usersList = (user_t *) malloc(sizeof(user_t));

}

/*
 * Adds a hard coded mail with given properties to the given user's inbox.
 *
 * @param	sender		Sender of the mail.
 * @param	receiver	Receiver of the mail.
 * @param	subject		Subject of the mail.
 * @param	date		Date of the mail.
 * @param	content		Content of the mail.
 * @param	key			Encryption key of the mail.
 */
void addHardCodedMail(user_t *sender, user_t *receiver, char *subject, char *date, char *content, int key) {

	mail_t *mail = malloc(sizeof(mail_t));

	mail->sender = sender;
	strcpy(mail->header[0], receiver->address);
	strcpy(mail->header[1], subject);
	strcpy(mail->header[2], date);
	char text[50];
	strcpy(text, content);
	caesarEncrypt(key, text);
	strcpy(mail->content, text);

	addMail(mail, receiver);

}
