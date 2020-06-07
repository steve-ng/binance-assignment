
Java Backend Engineer Assignment


Design and code a RESTful API for a Content Management System (CMS) for Binance. 

The CMS would used to post articles to the public. 
The current Binance site supports up to 17 different languages. 
Each article would have some translations but not all articles have all of the 17 translations. 
The API should have public and private endpoints. 

-> The public endpoints should only allow reading of data
-> whereas the private endpoints allow the writing of data. The private endpoints should be protected by an authentication system. 


Derive your own data model as deem fit. Use the latest Java version and any SQL-based database. Include tests as needed, although it is not a mandatory requirement.


Submit the code as a GitHub repository and make sure that the GitHub repository is public. Remember to add a README file for instructions on how to run the application and explanations (if any).


/article/{title}


================ database design

article
    id

article_translation
    language
    title UNIQUE
    content
    meta
    article_id
    
article_related

article_category
    
    
    
/api/pages/{title}?lang-param
    
    
 fetch("https://api.binance.vision/api/pages/mining-pools-explained?lang=en", {
   "headers": {
     "accept": "*/*",
     "accept-language": "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7",
     "sec-fetch-dest": "empty",
     "sec-fetch-mode": "cors",
     "sec-fetch-site": "cross-site"
   },
   "referrer": "https://academy.binance.com/",
   "referrerPolicy": "strict-origin-when-cross-origin",
   "body": null,
   "method": "GET",
   "mode": "cors",
   "credentials": "omit"
 });
 
 {
    "id":2264,
    "title":"Blockchain Use Cases: Prediction Markets",
    "slug":"blockchain-use-cases-prediction-markets",
    "meta":"Prediction markets are markets that deal in data. They can be used in everything from betting to forecasting future events. Learn more at Binance Academy.",
    "image":{
       "thumbnail":"uploads-thumbnails/2c2ba943014f445f856d5f005ba8ef2b.png",
       "original":"uploads/2c2ba943014f445f856d5f005ba8ef2b.png"
    },
    "content":"\u003cp\u003e\u003cstrong\u003eContents\u003c/strong\u003e\u003c/p\u003e\u003cul\u003e\u003cli\u003e\u003ca href\u003d\"#introduction\" rel\u003d\"noopener noreferrer\"\u003eIntroduction\u003c/a\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#what-are-prediction-markets\" rel\u003d\"noopener noreferrer\"\u003eWhat are prediction markets?\u003c/a\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#why-are-prediction-markets-useful\" rel\u003d\"noopener noreferrer\"\u003eWhy are prediction markets useful?\u003c/a\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#prediction-markets-and-blockchain-technology\" rel\u003d\"noopener noreferrer\"\u003ePrediction markets and blockchain technology\u003c/a\u003e\u003cul\u003e\u003cli\u003e\u003ca href\u003d\"#censorship-resistance\" rel\u003d\"noopener noreferrer\"\u003eCensorship resistance\u003c/a\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#no-middlemen\" rel\u003d\"noopener noreferrer\"\u003eNo middlemen\u003c/a\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#permissionless\" rel\u003d\"noopener noreferrer\"\u003ePermissionless\u003c/a\u003e\u003c/li\u003e\u003c/ul\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#the-power-of-blockchain-oracles\" rel\u003d\"noopener noreferrer\"\u003eThe power of blockchain oracles\u003c/a\u003e\u003c/li\u003e\u003cli\u003e\u003ca href\u003d\"#closing-thoughts\" rel\u003d\"noopener noreferrer\"\u003eClosing thoughts\u003c/a\u003e\u003c/li\u003e\u003c/ul\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch2 id\u003d\"introduction\"\u003eIntroduction\u003c/h2\u003e\u003cp\u003eWhen you stumble across the terms \u003cem\u003eblockchain\u003c/em\u003e and \u003cem\u003emarkets\u003c/em\u003e in the same sentence, you no doubt consider the booming ecosystem of exchanges facilitating\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/blockchain/what-is-cryptocurrency\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003ecryptocurrency\u003c/a\u003e trades.\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/blockchain/what-is-blockchain-technology-a-comprehensive-guide-for-beginners\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eBlockchain technology\u003c/a\u003e is incredibly versatile, however, and allows for markets of all sorts to be built on top of it.\u003c/p\u003e\u003cp\u003eFinancial assets can be either physical objects (tangible) or digital goods (intangible). But regardless of the type, where there are assets that hold value, there is a potential market.\u003c/p\u003e\u003cp\u003eIn this article, we\u0026rsquo;ll take a look at a particular kind of market that could benefit significantly from blockchain technology \u0026ndash; prediction markets.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch2 id\u003d\"what-are-prediction-markets\"\u003eWhat are prediction markets?\u003c/h2\u003e\u003cp\u003eA prediction market is a speculative market where participants trade not on\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/economics/what-are-options-contracts\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eoptions\u003c/a\u003e or cryptocurrencies, but instead on information. Specifically, investors in prediction markets bet on the outcomes of future events.\u003c/p\u003e\u003cp\u003eThis can be any event conceivable (provided, of course, that a broker is willing to list it). Let\u0026rsquo;s take the example of a question with a yes/no outcome:\u0026nbsp;\u003cem\u003eWill a train from the US to Europe run by 2025?\u003c/em\u003e\u003c/p\u003e\u003cp\u003eThere are two possibilities here. Either it will, or it won\u0026rsquo;t. If you\u0026rsquo;re confident that such a train will not be operational in the next five years, you could purchase a number of\u0026nbsp;\u003cem\u003eno\u003c/em\u003e contracts. These might be priced somewhere between $0 and $1.\u0026nbsp;\u003c/p\u003e\u003cp\u003eIf the train is not running by the deadline,\u0026nbsp;\u003cem\u003eno\u003c/em\u003e contracts will be redeemable for $1, and\u0026nbsp;\u003cem\u003eyes\u003c/em\u003e contracts will have no value. Conversely, if it does operate, then\u0026nbsp;\u003cem\u003eno\u003c/em\u003e contracts will be worth nothing while\u0026nbsp;\u003cem\u003eyes\u003c/em\u003e contracts will be worth $1.\u003c/p\u003e\u003cp\u003eIn the meantime, the value will fluctuate as market sentiment changes, and new information becomes available. In our above example, for instance, prices of\u0026nbsp;\u003cem\u003eno\u003c/em\u003e contracts might increase if there is no development in underwater tunnel technology as the deadline nears. An announcement that a major company plans to roll this train service out for 2024 might, however, cause the price of\u0026nbsp;\u003cem\u003eyes\u003c/em\u003e contracts to increase.\u003c/p\u003e\u003cp\u003eIt seems like a standard speculative market. Participants will purchase contracts in the hopes that they\u0026rsquo;ll increase in value over time. But prediction markets are far from your average speculative platform. When used correctly, they can be powerful forecasting instruments.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch2 id\u003d\"why-are-prediction-markets-useful\"\u003eWhy are prediction markets useful?\u003c/h2\u003e\u003cp\u003eChances are that, in placing a bet, a market participant has some knowledge that influences their decision. Unlike in regular gambling, there are external factors that will impact the likelihood of particular outcomes.\u003c/p\u003e\u003cp\u003eSmart investors will do their research, and experts will weigh in. Those with insider knowledge or familiarity with the subject matter will invest in the contracts they feel are most likely to be worth more. In a nutshell,\u0026nbsp;\u003cstrong\u003eprediction markets serve as aggregators of information.\u003c/strong\u003e\u003c/p\u003e\u003cp\u003eIn our cross-continental train example, if\u0026nbsp;\u003cem\u003eno\u003c/em\u003e contracts are trading at $0.90 and\u0026nbsp;\u003cem\u003eyes\u003c/em\u003e contracts at $0.10, it tells us that relatively few people have faith in the concept\u0026rsquo;s success. The market\u0026rsquo;s collective insights have been reflected in the data, as those with information are economically incentivized to \u0026lsquo;report\u0026rsquo; their knowledge.\u003c/p\u003e\u003cp\u003ePrediction markets excel at amassing and representing information. They work on the principle that the\u0026nbsp;\u003cem\u003ewisdom of the crowds\u003c/em\u003e will always be superior to the data known to only a few experts. By examining these markets, stakeholders across all industries \u0026ndash; from IT to renewable energies \u0026ndash; can benefit from understanding what the ecosystem believes is likely to occur. More than that, the markets crowdsources information to get an accurate picture of future outcomes.\u003c/p\u003e\u003cp\u003eProponents even believe that prediction markets could serve as a core technology in a new form of democracy known as\u0026nbsp;\u003cem\u003efutarchy\u003c/em\u003e.\u003c/p\u003e\u003cp\u003eWe need not have\u0026nbsp;\u003cem\u003eyes\u003c/em\u003e and\u0026nbsp;\u003cem\u003eno\u003c/em\u003e contracts, either. We can use any mutually-exclusive outcomes \u0026ndash; one popular example is that of a presidential election. Suppose that two candidates, Candidate A and Candidate B, are competing. Betters could buy\u0026nbsp;\u003cem\u003eCandidate A\u003c/em\u003e contracts if they believe Candidate A will win, and\u0026nbsp;\u003cem\u003eCandidate B\u003c/em\u003e ones otherwise.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003chr\u003e\u003cp style\u003d\"text-align: center;\"\u003e\u003ca href\u003d\"https://www.binance.com/en/buy-Bitcoin?utm_source\u003dBinanceAcademy\" target\u003d\"_blank\"\u003e\u003cstrong\u003eLooking to get started with cryptocurrency? Buy Bitcoin on Binance!\u003c/strong\u003e\u003c/a\u003e\u003c/p\u003e\u003chr\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch2 id\u003d\"prediction-markets-and-blockchain-technology\"\u003ePrediction markets and blockchain technology\u003c/h2\u003e\u003cp\u003ePrediction markets may very well be formidable tools, but their value proposition could be greatly strengthened if they were to be decentralized. Centralized platforms today are limited in what they offer \u0026ndash; whether due to local regulations or to owners\u0026rsquo; reluctance to list certain contracts. Ultimately, users must trust the operator of such a platform, and pay additional fees for the ability to make use of their services.\u0026nbsp;\u003c/p\u003e\u003cp\u003eThe conventional centralized model can be replaced by decentralized alternatives with a blockchain-based approach. This can provide many benefits, such as censorship-resistance, a reduced number of intermediaries, and increased accessibility.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch3 id\u003d\"censorship-resistance\"\u003eCensorship-resistance\u003c/h3\u003e\u003cp\u003eIncumbent prediction markets are typically run by a single party. This means that entities such as government authorities or malicious actors can easily shut them down. Decentralized platforms cannot be taken down so easily.\u003c/p\u003e\u003cp\u003eWhen governed by\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/blockchain/what-are-smart-contracts\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003esmart contracts\u003c/a\u003e, this single point of failure no longer exists. Every\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/blockchain/what-are-nodes\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003enode\u003c/a\u003e on the network runs the code. Should the contracts be built in a certain way, no user will be able to edit or delete the programs that underpin the market.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch3 id\u003d\"no-middlemen\"\u003eNo middlemen\u003c/h3\u003e\u003cp\u003eBlockchains don\u0026rsquo;t require administrators. As the work traditionally done by third parties is outsourced to automated code, there is no longer a need for intermediaries. Users interact directly with smart contracts, meaning that they don\u0026rsquo;t pay fees to a third party (as would be expected with a centralized platform). This also removes some counterparty risk since the user isn\u0026rsquo;t trusting anyone.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch3 id\u003d\"permissionless\"\u003ePermissionless\u003c/h3\u003e\u003cp\u003eWith decentralized prediction markets, individuals around the world are free to place bets or to create contracts available to users globally. Geographic and regulatory restrictions that plagued previous platforms could cease to be a problem.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch2 id\u003d\"the-power-of-blockchain-oracles\"\u003eThe power of blockchain oracles\u003c/h2\u003e\u003cp\u003eIf there\u0026rsquo;s no broker and no form of central authority, how do we determine which outcome has occurred at the time of expiry?\u003c/p\u003e\u003cp\u003eWe would need some kind of \u0026ldquo;truth\u0026rdquo; mechanism here \u0026ndash; and this is where\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/blockchain/blockchain-oracles-explained\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eblockchain oracles\u003c/a\u003e come into play. We want to be able to draw on a source of data that tells us with certainty whether an outcome did or did not happen. To do this, there are a handful of possible approaches.\u0026nbsp;\u003c/p\u003e\u003cp\u003eThe simplest would be to tap into a third-party website or feed, but that fundamentally undermines the use of a blockchain. After all, the third-party would be in control of the outcomes \u0026ndash;\u0026nbsp;they could choose to lie for their own gain, or become a target by those seeking to cheat.\u003c/p\u003e\u003cp\u003eAnother option is to financially incentivize users to truthfully report on events.\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/blockchain/what-is-staking\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eStaking\u003c/a\u003e mechanisms can be implemented, which require that users put forward tokens to report. Should they report correctly, they will receive some form of remuneration. Attempt to cheat, however, and they will lose their stake. This model is used by\u0026nbsp;\u003ca href\u003d\"https://www.augur.net/\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eAugur\u003c/a\u003e, the first blockchain prediction markets platform, for dispute resolution. Others, such as\u0026nbsp;\u003ca href\u003d\"https://gnosis.io/\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eGnosis\u003c/a\u003e, allow users to pick from a range of centralized and decentralized solutions.\u003c/p\u003e\u003cp\u003eThe use of blockchain oracles in prediction markets is a relatively new concept. As a nascent technology, we have yet to see which form of oracle is best suited to the different types of prediction markets. Last year,\u0026nbsp;\u003ca href\u003d\"https://research.binance.com/analysis/augur-design-flaws\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eBinance Research\u003c/a\u003e published a report on the matter. Notably, they identified a\u0026nbsp;\u003ca href\u003d\"https://academy.binance.com/glossary/design-flaw-attack\" rel\u003d\"noopener noreferrer\" target\u003d\"_blank\"\u003eDesign Flaw Attack\u003c/a\u003e and other flaws in one of the most popular implementations of prediction markets.\u003c/p\u003e\u003cp\u003e\u003cbr\u003e\u003c/p\u003e\u003ch2 id\u003d\"closing-thoughts\"\u003eClosing thoughts\u003c/h2\u003e\u003cp\u003ePrediction markets are exciting tools for betting on future outcomes, but they\u0026rsquo;re also sophisticated instruments for gleaning reliable information on virtually anything. By financially incentivizing individuals to share their own knowledge on a market, we can generate insights into social, industrial, and political trends.\u003c/p\u003e\u003cp\u003eAs it stands, the shortcomings of centralized platforms prevent prediction markets from living up to their true potential. But that\u0026rsquo;s poised to change with decentralized alternatives. As more capable oracles are developed, blockchain technology could host provably fair code that can\u0026rsquo;t be tampered with.\u003c/p\u003e",
    "language":"en",
    "created_at":"Feb 28, 2020",
    "category_id":5,
    "reading_time":335500,
    "text_to_speech":"db1b3503-d04e-4279-a686-db0aaae52495.mp3",
    "related":[
       {
          "id":1767,
          "title":"What Is Staking?",
          "slug":"what-is-staking",
          "image":{
             "thumbnail":"uploads-thumbnails/ddbd6bec04984e74b9fbc735aa210646.png",
             "original":"uploads/ddbd6bec04984e74b9fbc735aa210646.png"
          },
          "language":"en",
          "created_at":"Sep 22, 2019",
          "reading_time":439500
       },
       {
          "id":1278,
          "title":"Hybrid PoW/PoS Consensus Explained",
          "slug":"hybrid-pow-pos-consensus-explained",
          "image":{
             "thumbnail":"uploads-thumbnails/3fyAH9UmNHwAsiK3PPKb.png",
             "original":"uploads/3fyAH9UmNHwAsiK3PPKb.png"
          },
          "language":"en",
          "created_at":"Mar 25, 2019",
          "reading_time":531750
       },
       {
          "id":1473,
          "title":"Crypto Wallet Types Explained",
          "slug":"crypto-wallet-types-explained",
          "video":"https://youtu.be/d8IBpfs9bf4",
          "image":{
             "thumbnail":"uploads-thumbnails/8wrN5Fn8mVnHPNyIk0hH.png",
             "original":"uploads/8wrN5Fn8mVnHPNyIk0hH.png"
          },
          "language":"en",
          "created_at":"Jun 18, 2019",
          "reading_time":446000
       }
    ],
    "next":"a-guide-to-crypto-collectibles-and-non-fungible-tokens-nfts",
    "availableLanguages":[
       "de",
       "en",
       "es",
       "id",
       "it",
       "nl",
       "pl",
       "tr"
    ],
    "category":{
       "id":5,
       "slug":"blockchain"
    }
 }
 
 
Accessing in memory database

- visit  http://localhost:8080/h2-console
- jdbc url: jdbc:h2:mem:testdb 
- username sa
- password: leave as empty


URL
- http://localhost:8080/v1/pages/x?language=EN