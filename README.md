### Introduction ###
This is a sample java project to download all the Transactions for a given Ethereum Wallet Address and export them to a CSV File.
In order to retrieve the Transaction data, it currently uses the Etherscan APIs to fetch transactions for a given wallet address.

The following categories of Transactions are currently supported for a given wallet address, and a csv file is generated for each of them:
Normal (External) Transactions
Internal Transactions
ERC20 Token Transfer Events
ERC721 Token Transfer Events
ERC1155 Token Transfer Events

### Project Requirements ###
Java 23
Gradle 8


### Build Project ###
./gradlew clean build

The Generated Jar can be found under directory build/libs/cointracker-1.0.SNAPSHOT.jar


### Usage ###
java -jar build/libs/cointracker-1.0-SNAPSHOT.jar -Detherscan.apikey=<Etherscan API Key> -Dscv.writer.basedir=<Path to output directory>


### Output ###
The above command should generate the output as follows for the wallet address 0xa39b189482f984388a34460636fea9eb181ad1a6:

/tmp/cointracker
├── 0xa39b189482f984388a34460636fea9eb181ad1a6
    ├── ERC1155Transactions.csv
    ├── ERC20Transactions.csv
    ├── ERC721Transactions.csv
    ├── InternalTransactions.csv
    └── NormalTransactions.csv
