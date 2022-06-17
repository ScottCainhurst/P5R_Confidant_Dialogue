    package com.android.example.p5rconfidantdialoguev2.Database

import android.app.Application
import com.android.example.p5rconfidantdialoguev2.dialogueText

    class ConfidantApplication: Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    companion object{
        private lateinit var instance: ConfidantApplication

         val database: ConfidantRoomDatabase by lazy{
            ConfidantRoomDatabase.buildDatabase(instance)
        }

        val repository: ConfidantRepository by lazy {
            ConfidantRepositoryImpl(
                    database.confidantDao()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if(repository.getConfidant().isEmpty()){
            repository.insertDialogue(
                    listOf(
                        //Ryuji's dialogue
                        dialogueText("\nI'm counting on you. +3\nYou seem pretty excited. +3\n...Help with what? +2\n"+
                                "\n"+
                                "What about them ? +0\nAnd then you punched him ? +0\n"+
                                "\n"+
                                "Do you want to go back ? +2\nDo you regret it ? +2\n"+
                                "\n"+
                                "You're already fast enough. +2\nAre your legs okay? +2\nIt's never too late, man. +2\n",0,0),

                        dialogueText("\nLet's not fight. + 2\n"+ "Want to train with us ? +0\n"+ "It's nice to meet you. + 0\n"+
                                "\n"+
                                "Calm down, Ryuji. + 3\n"+ "Just endure it. + 2\n"+ "I'll shut them up. + 0\n"+
                                "\n"+
                                "I can't exactly blame you. + 2\n"+ "Violence is not the answer. + 0\n"+"Yeah, that'd be best. + 0\n",0,1),

                        dialogueText("\nNakaoka? +0\n"+ "Are you worried about him? +2\n"+ "Just leave him be. +0\n"+
                                "\n"+
                                "But you're doing great. + 3\n"+	"It's not so bad. + 2\n"+ "I know how you feel. + 3\n",0,2),

                        dialogueText("\nA towel? +2\n"+	"Protein powder? +3\n"+
                                "\n"+
                                "You seem conflicted. + 2\n"+	"Do you want to rejoin ? +2\n"+	"You're done with them, right ? +0\n"+
                                "\n"+
                                "So he's short ? +2\n"+	"So he's an asshole ? +3\n"+
                                "\n"+
                                "Don't worry.I gotcha. + 2\n"+	"I haven't agreed to anything. +0\n"+ "Fine, but you're buying ramen. + 0\n",0,3),

                        dialogueText("\nLet's stay here. +2\n"+	"How about Protein Lovers? +2\n"+	"We can train at my place. +3\n"+
                                "\n"+
                                "You guys should trust Nakaoka. + 3\n"+	"This is no time for arguing. + 3\n"+
                                "\n"+
                                "Absolutely. + 3\n"+	"More or less. + 3\n"+	"Not in the slightest. + 0\n"+
                                "\n"+
                                "I don't get it. + 0\n"+	"Can you explain that ? + 0\n"+
                                "\n"+
                                "...Huh ? +0\n"+	"I really don't understand. + 0\n"+
                                "\n"+
                                "Sounds like you two were close. + 0\n"+	"Just like you.So he should've punched back ? +2\n",0,4),

                        dialogueText("\nShould we change his heart? +0\n"+	"Let's talk to Takeishi. +3\n"+
                                "\n"+
                                "I think it's cool, Ryuji. + 3\n"+	"Wait, what ? +2\n"+
                                "\n"+
                                "Never know until you try + 2\n"+	"It's out of our hands. + 0\n"+	"We'll use force if we have to. + 0\n",0,5),

                        dialogueText("\nWhat if they start fighting? +0\n"+"I doubt they'll believe you. +0\n"+
                                "\n"+
                                "Things turned out for the best. + 3\n"+"You deserved it. + 3\n"+
                                "\n"+
                                "All I did was watch. + 3\n"+"Are you gonna pay me back ? +2\n"+
                                "\n"+
                                "But I was just standing here... + 2\n"+ "You weren't cool though. + 3\n"+
                                "\n"+
                                "You did a great job. + 0\n"+"So. Closed case ? +2\n"+"We make a good team too. + 0\n",0,6),

                        dialogueText("\nAre you satisfied now? +3\n"+	"Not Running? +2\n"+
                                "\n"+
                                "What did you say ? +2\n"+ "Do you have any time for that ? +2\n"+	"Don't do it. + 3\n"+
                                "\n"+
                                "You're Right. + 3\n"+	"I never realized that. + 3\n"+
                                "\n"+
                                "I agree. + 2\n"+	"Be more specific. + 0\n"+	"And where is this place ? +0\n"+
                                "\n"+
                                "Congratulations. + 2\n"+ "Got him under control, how ? +0\n"+ "Better watch out for them. + 2\n",0,7),

                        dialogueText("\nI'm looking forward to it. +3\n"+	"We can't lose either. +3\n"+
                                "\n"+
                                "You're welcome. +0\n"+	"It's all because of you. +0\n",0,8),


                        //Maruki's dialogue
                        dialogueText("\nDidn't have much choice. +0\n"+ "We made a deal. +2\n"+ "I'm a little nervous. +2\n"+
                                "\n"+
                                "It's in the past. +0\n"+ "I'm doing okay now. +0\n"+ "So much for privacy. +0\n"+
                                "\n"+
                                "But it sounds right. +3\n"+ "Yep. +2\n"+ "Kinda creeping me out here. +0\n"+
                                "\n"+
                                "So... what? +0\n"+ "I'll need more details. +0\n"+ "Uh... +0\n"+
                                "\n"+
                                "Well, okay. +2\n"+ "Better make it worth it. +0\n"+ "Why me, though? +0\n",1,0),

                        dialogueText("\nSo they have, huh? +2\n"+ "You worry too much. +0\n"+ "Thanks to you, probably. +2\n"+
                                "\n"+
                                "Of course. +2\n"+ "Yeah, for our deal. +2\n"+ "I forgot. +0\n"+
                                "\n"+
                                "When someone betrays me. +0\n"+ "When I lie. +0\n"+ "When I get punched. +0\n"+
                                "\n"+
                                "That one seems necessary +2\n"+ "We'd be better off without it. +0\n"+ "It's a seed for new loves. +2\n"+
                                "\n"+
                                "Did that help? +2\n"+ "Don't worry about it. +2	\n"+
                                "\n"+
                                "Good work over there. +2\n"+ "So you're actually working? +0\n"+ "Getting to your research now? +0\n",1,1),

                        dialogueText("\nWhere's this coming from? +0\n"+ "What are you talking about? +0\n"+
                                "\n"+
                                "I know, right...? +3\n"+ "It's not the worst. +0\n"+ "Talk about a reward. +2\n"+
                                "\n"+
                                "That'd be great. +2\n"+ "Is that possible? +0\n"+ "Is that what you're researching? +3\n"+
                                "\n"+
                                "..... +0\n"+ "Are you okay? +0\n"+
                                "\n"+
                                "That's a grand plan. +2\n"+ "You're so kind. +2\n"+
                                "\n"+
                                "That sounds fun. +3\n"+ "I'm not the" +"\"" + "free labor" + "\"" + "type. +0\n"+ "Nope. +0\n"+
                                "\n"+
                                "I'm completely fine. +2\n"+ "It's part of our deal, so... +2\n"+ "I'm struggling, to be honest. +0\n",1,2),

                        dialogueText("\nThis looks great! +3\n"+ "How old do you think I am? +0\n"+ "I could just take cash... +2\n"+
                                "\n"+
                                "The one-cookie container. +0\n"+ "The ten-cookie container. +0\n"+ "It was a tie. +0\n"+
                                "\n"+
                                "I never considered that. +0\n"+ "They're getting played. +2\n"+ "You know, you're right. +3\n"+
                                "\n"+
                                "My senses lied to me! +2\n"+ "Hey, as long as it tastes good. +2\n"+ "It's a little scary.  +0\n"+
                                "\n"+
                                "Not " + "\"" + "truth" + "\"" + "exactly... +0\n"+ "I guess so. +2\n"+ "I don't know. +0\n"+
                                "\n"+
                                "I really don't mind. +2\n"+ "Come on, man. +0\n"+ "It was thought-provoking. +2\n",1,3),

                        dialogueText("\nYou wanted to talk? +0\n"+ "Another cup? +2\n"+ "We've got curry, too. +2\n"+
                                "\n"+
                                "I can do that. +3\n"+ "It's a deal. +2\n"+ "I'm not up for this... +0\n"+
                                "\n"+
                                "Isn't that enough? +0\n"+ "You need more than that? +0\n"+
                                "\n"+
                                "So what CAN we do? +0\n"+ "It's a hard question... +0\n"+ "So give up. +2\n"+
                                "\n"+
                                "All hearts share some things. +0\n"+ "What if they're connected? +0\n"+
                                "\n"+
                                "Calm down. +0\n"+ "Where's this coming from? +0\n"+ "Cognitive pscience? +0\n"+
                                "\n"+
                                "Calm down. +2\n"+ "What's going on? +2\n"+ "Heavy breathing? Pervert. +0\n"+ "Heavy breathing? Pervert. +0\n",1,4),

                        dialogueText("\nYou really are dedicated. +3\n"+ "Are they even relevant? +3\n"+ "Are you a fan? +3\n"+
                                "\n"+
                                "No idea. +3\n"+ "As in, removing them? +3\n"+ "How about you Maruki? +3\n"+
                                "\n"+
                                "The change of heart...? +3\n"+ "..... +3\n"+
                                "\n"+
                                "I have no clue. +3\n"+ "Sounds pretty far-fetched. +3\n"+ "It's intriguing. +3\n",1,5),

                        dialogueText("\nI'm good on cookies, thanks. +2\n"+ "What do you mean? +3\n"+ "Thanks, but I should get going. +0\n"+
                                "\n"+
                                "Ooh, really? +3\n"+ "Can you afford that? +2\n"+ "Sorry, I prefer sushi. +2\n"+
                                "\n"+
                                "Thanks for the food! +3\n"+ "Self-control much? +0\n"+ "This is quite the spread. +2\n"+
                                "\n"+
                                "I'm his pupil. +2\n"+ "It's complicated. +0\n"+ "We've made a deal. +3\n"+
                                "\n"+
                                "Congratulations. +3\n"+ "Way to go. +3\n"+
                                "\n"+
                                "I sure do. +3\n"+ "Let's celebrate. +3\n"+
                                "\n"+
                                "She's a girlfriend of yours? +0\n"+ "Who's Rumi? +0\n"+ "Should I leave you two to talk? +0\n"+
                                "\n"+
                                "He's a good friend. +2\n"+ "Learn some independence. +0\n"+ "You'll get the tab next time. +0\n",1,6),

                        dialogueText("\nYeah. +0\n"+ "Kind of. +0\n"+
                                "\n"+
                                "Kind of sad... +3\n"+ "Is our deal over? +2\n"+ "Well... take care of yourself. +2\n",1,7),

                        dialogueText("\nStory progression for Maruki's rank 10",1,8),

                        //Takemi's dialogue
                        dialogueText("\nFine by me. +1\n"+ "Please go easy on me. +3\n"+ "So many pretty lights... +1\n"+
                                "\n"+
                                "I have a bad heart. +2\n"+ "We're on a date. +0\n"+ "I know my rights. +0\n"+
                                "\n"+
                                "I agree. +2\n"+ "Harassment? +0\n"+ "The Plague? +0\n"+
                                "\n"+
                                "I'm totally fine. +2\n"+ "I feel lightheaded +0\n"+ "I think I have superpowers +2\n",2,0),

                        dialogueText("\nWhat was that about? +0\n"+ "Was that an emergency? +0\n"+
                                "\n"+
                                "A medical error? +0\n"+ "What do you mean? +0\n"+
                                "\n"+
                                "I don't mind. +2\n"+ "Is it true? +0\n"+ "I need the medicine. +2\n"+
                                "\n"+
                                "Of course not. +2\n"+ "I don't think I did... +0\n"+ "Have you? +0\n",2,1),

                        dialogueText("\nYou'll be OK. +0\n"+ "Dr. Takemi will help. +2\n"+
                                "\n"+
                                "You seem happy. +3\n"+ "You're so kind. +2\n"+ "Why free? +2\n"+
                                "\n"+
                                "I'll reflect on my mistakes +2\n"+ "But she ended up okay. +0\n"+ "Punish me more. +0\n",2,2),

                        dialogueText("\nThey trust you. +0\n"+ "Was it really your fault? +0\n"+
                                "\n"+
                                "I had no idea. +0\n"+ "It's not too late. +0\n"+
                                "\n"+
                                "That's good. +3\n"+ "When will it be done? +2\n"+ "\"Probably\"+0\n"+
                                "\n"+
                                "About Miwa-chan? +2\n"+ "About Oyamada? +0\n"+ "About Crawford-Ende's? +0\n",2,3),

                        dialogueText("\nWell, someone's popular. +0\n"+ "You seem annoyed. +0\n"+ "Did something happen? +0\n"+
                                "\n"+
                                "Having fun? +0\n"+ "You ARE a genius. +0\n"+
                                "\n"+
                                "You're a masochist. +0\n"+ "It suits you. +3\n"+ "You're not honest. +2\n"+
                                "\n"+
                                "You can count on me. +2\n"+ "I think I'm at my limit... +0\n"+ "Anything for you. +2\n",2,4),

                        dialogueText("\nThis is harassment. +2\n"+ "She's a great doctor. +2\n"+ "Please be quiet. +2\n"+
                                "\n"+
                                "Don't lose hope. +0\n"+ "Let's ask for details. +0\n"+ "...... +0\n"+
                                "\n"+
                                "Just rest for today. +2\n"+ "Anything I can do? +2\n"+ "Let's retaliate. +0\n"+
                                "\n"+
                                "It was inevitable. +0\n"+ "We all do sometimes. +3\n"+ "I'm glad you did. +2\n",2,5),

                        dialogueText("\nMiwa-chan is alive. +0\n"+ "Oyamada lied to you. +0\n"+
                                "\n"+
                                "You should hurry. +2\n"+ "Let's get to work, doctor. +3\n"+ "It's not over yet. +3\n"+
                                "\n"+
                                "It's for Miwa-chan +3\n"+ "It's for my exams. +2\n"+ "It's for you. +3\n"+
                                "\n"+
                                "I'll be cheering you on. +2\n"+ "Don't burn yourself out. +0\n"+ "Anything else I can do. +2\n",2,6),

                        dialogueText("\nDon't worry about it. +2\n"+ "It was for my exams. +2\n"+ "It was rough. +3\n"+
                                "\n"+
                                "That's troubling. +0\n"+ "And your patients? +0\n"+
                                "\n"+
                                "I wanted to see you. +0 (ROMANCE)\n"+ "It was for my exams. +0 END\n"+
                                "\n"+
                                "I love you. +2 (ROMANCE)\n"+ "What do you think? +0 END\n"+
                                "\n"+
                                "It isn't a joke. +3 (ROMANCE)\n"+ "That sounds good. +0\n"+
                                "\n"+
                                "It's true love. +0\n"+ "So did you. +2\n"+ "I've always loved you. +0\n",2,7),

                        dialogueText("\nUh, what? +0\n"+ "Is that a joke? +0\n"+
                                "\n"+
                                "It's a coincidence. +0\n"+ "I wonder... +2\n"+ "So what if it's true? +0\n"+
                                "\n"+
                                "What kind? +2\n"+ "Yes, please. +3\n",2,8),
                        //Takemi 7.5
                        dialogueText("\nFine by me. +1\n"+ "Please go easy on me. +3\n"+ "So many pretty lights... +1\n"+
                                "\n"+
                                "I have a bad heart. +2\n"+ "We're on a date. +0\n"+ "I know my rights. +0\n"+
                                "\n"+
                                "I agree. +2\n"+ "Harassment? +0\n"+ "The Plague? +0\n"+
                                "\n"+
                                "I'm totally fine. +2\n"+ "I feel lightheaded +0\n"+ "I think I have superpowers +2\n",2,9),

                        //Ohya's dialogue
                        dialogueText("\nThanks +0\n"+ "Sounds like a good time. +0\n"+ "Doing what? +0\n"+
                                "\n"+
                                "Why do you ask? +0\n"+ "I don't. +0\n"+ "Mishima might... +2\n"+
                                "\n"+
                                "Worth...? +0\n"+ "What about their justice? +0\n"+
                                "\n"+
                                "I like the atmosphere. +0\n"+ "It's for the article. +2\n"+ "Tell me about that incident. +0\n",3,0),

                        dialogueText("\nMinors couldn't do that stuff. +0\n"+ "You might be right. +0\n"+ "You shouldn't make assumptions. +2\n"+
                                "\n"+
                                "What's the difference? +0\n"+ "I'm sure you are. +0\n"+
                                "\n"+
                                "Why not change careers? +0\n"+ "Maybe you should quit. +0\n"+
                                "\n"+
                                "What was she accused of? +0\n"+ "What happened? +0\n"+ "She was falsely accused? +2\n",3,1),

                        dialogueText("\nWhat's this about? +0\n"+ "She hasn't done anything wrong. +0\n"+
                                "\n"+
                                "Of course we are. +2\n"+ "Don't tell anybody. +2\n"+
                                "\n"+
                                "Our movie is about to start. +0\n"+ "That's enough. +0\n"+ "We're dating. Seriously. +0\n"+
                                "\n"+
                                "Leave it to me. +2\n"+ "That was our deal. +2\n"+ "Anything for my girlfriend. +0\n",3,2),

                        dialogueText("\nBecause of your investigation? +0\n"+ "Because of your incident? +0\n"+ "Are you sure we're the same? +0\n"+
                                "\n"+
                                "I'm curious. +0\n"+ "You can trust me. +0\n"+
                                "\n"+
                                "What was the cause of death? +0\n"+ "Who killed him? +0\n"+
                                "\n"+
                                "That sounds like defamation. +2\n"+ "That's unforgivable. +3\n"+ "How's your search going? +0\n"+
                                "\n"+
                                "I don't mind. +2\n"+ "As long as I'm compensated. +0\n"+ "I did the same to you. +0\n",3,3),

                        dialogueText("\nDid something bad happen? +0\n"+ "Having trouble at work? +0\n"+
                                "\n"+
                                "He must not like you. +2\n"+ "Did he find out? +0\n"+
                                "\n"+
                                "Do you have evidence of that? +0\n"+ "You should trust in her. +2\n"+ "You might be right. +0\n"+
                                "\n"+
                                "That's the spirit +2\n"+ "You're a great journalist. +2\n"+ "What about your quota? +0\n"+
                                "\n"+
                                "Glad to hear that. +0\n"+ "Don't work yourself to death. +0\n"+ "I'll dig up some more for you. +2\n",3,4),

                        dialogueText("\nWhat was that about? +0\n"+ "Could it be...? +0\n"+
                                "\n"+
                                "Calm down. +2\n"+ "Don't let him provoke you. +3\n"+ "Let's think of another way. +3\n"+
                                "\n"+
                                "You should work on that. +2\n"+ "You're charming as you are. +3\n"+
                                "\n"+
                                "That's the spirit. +2\n"+ "Sounds tough. +0\n"+ "Don't strain yourself. +0\n",3,5),

                        dialogueText("\nHe reflected on his actions. +0\n"+ "Aren't you happy? +0\n"+
                                "\n"+
                                "Did I? Can't remember. +0\n"+ "Uh, nope. +0\n"+
                                "\n"+
                                "I'm glad to hear that. +0\n"+ "Thank god. +0\n"+
                                "\n"+
                                "That's not like you. +3\n"+ "You need pursue the truth. +3\n"+ "I'll go with you. +3\n"+
                                "\n"+
                                "Good luck. +2\n"+ "Be careful. +2\n"+ "Grab a souvenir for me. +0\n",3,6),

                        dialogueText("\nAre you OK? +0\n"+ "Did you learn the truth? +0\n"+
                                "\n"+
                                "What are you going to do? +0\n"+ "You're not giving up, are you? +2\n"+
                                "\n"+
                                "I can't leave you. +3\n"+ "I want to help. +3\n"+ "I need those articles. +0\n"+
                                "\n"+
                                "Of course not. +0\n"+ "No way. +0\n"+
                                "\n"+
                                "I took it seriously. +0 (ROMANCE)\n"+ "I didn't take it seriously. +0 END\n"+
                                "\n"+
                                "I love you, Ichiko. +0 (ROMANCE)\n"+ "I'm just kidding. +0\n"+
                                "\n"+
                                "I wanted to hear your voice. +2\n"+ "Please don't dump me. +2\n"+ "IloveyouIloveyouIloveyou. +0\n",3,7),

                        dialogueText("\nYou're really earnest. +2\n"+ "Is that entertainment? +3\n"+ "You don't need my info? +0\n"+
                                "\n"+
                                "I'm glad to hear that. +3\n"+ "I'll read the next issue. +3\n"+
                                "\n"+
                                "So you knew all along? +0\n"+ "It's just a coincidence. +0\n"+ "Lala's the real phantom thief. +0\n"+
                                "\n"+
                                "It's up to you. +3\n"+ "I want to go to your place. +3\n",3,8),
                        //Ohya 7.5
                        dialogueText("\nLike what? +0\n"+ "You seem tired. +2\n"+ "So... I have a pet cat... +0\n"+
                                "\n"+
                                "What's the chief's name? +0\n"+ "Tell me more about him. +0\n",3,9),

                        //Yusuke's dialogue
                        dialogueText("\nRank 1 Followup:\n"+ "Thanks. +2\n"+ "I'll try not to. +2\n"+ "I'll be asking a lot. +3\n"+
                                "\n"+
                                "It's novel. +2\n"+ "It's enigmatic. +2\n"+ "...What is it? +0\n"+
                                "\n"+
                                "I can't wait. +3\n"+ "I hope you're right. +3\n"+ "Will people like it? +0\n"+
                                "\n"+
                                "You're already doing enough. +2\n"+ "I'm looking forward to it. +0\n"+ "Will you really? +0\n",4,0),

                        dialogueText("\nThat was harsh. +0\n"+ "What a dick. +0\n"+ "Don't let it bother you. +2\n"+
                                "\n"+
                                "Stop exaggerating. +0\n"+ "This is just the beginning. +0\n"+ "Stand up. +0\n"+
                                "\n"+
                                "You're really giving up? +2\n"+ "This isn't like you. +3\n"+ "Stand up, Ysuke. +0\n"+
                                "\n"+
                                "How exactly? +2\n"+ "That's the spirit. +2\n"+
                                "\n"+
                                "That's the spirit. +2\n"+ "You're taking this too far. +0\n"+ "That's all? +0\n",4,1),

                        dialogueText("\nWhat are we doing here? +0\n"+ "Why are we in a boat? +2\n"+ "I should bring a girl here. +2\n"+
                                "\n"+
                                "Love comes in all forms. +3\n"+ "Maybe you should train more. +2\n"+ "You have a wild imagination. +0\n"+
                                "\n"+
                                "Don't get discouraged. +2\n"+ "Just keep drawing. +0\n"+ "You lack love yourself. +0\n",4,2),

                        dialogueText("\nMake me beautiful. +0\n"+ "I dunno if I can do it... +2\n"+ "Do you want me to strip? +3\n"+
                                "\n"+
                                "I'm sure you will. +3\n"+ "It doesn't look like it. +3\n"+ "Do you want to give up? +2\n"+
                                "\n"+
                                "Don't overthink it. +0\n"+ "You have to keep drawing. +0\n"+ "There's still hope. +2\n",4,3),

                        dialogueText("\nIt feels nostalgic. +2\n"+ "Why are we here again? +0\n"+ "Are you going in? +0\n"+
                                "\n"+
                                "We should get it fixed. +0\n"+ "Let's force it open. +0\n"+
                                "\n"+
                                "Are you OK? +0\n"+ "You're not looking so good. +0\n"+
                                "\n"+
                                "Maybe he was sympathetic. +3\n"+ "He somehow knew you had skill. +2\n"+ "I couldn't possibly tell you. +3\n"+
                                "\n"+
                                "He had a certain dignity. +2\n"+ "He seems reliable. +0\n"+ "I'm not sure. +0\n",4,4),

                        dialogueText("\nThat's a great name. +0\n"+ "What do you mean? +2\n"+ "Handsome...? +0\n"+
                                "\n"+
                                "The truth is within you. +3\n"+ "Money is important. +0\n"+
                                "\n"+
                                "Calm down. +2\n"+ "It's not a crime to enjoy sushi. +2\n"+ "Let's go again sometime. +0\n",4,5),

                        dialogueText("\nScenery is always nice. +0\n"+ "I'd say Morgana. +0\n"+ "It has to be Ann. +2\n"+
                                "\n"+
                                "What's wrong with that? +2\n"+ "The same applies to everyone. +0\n"+ "You've really grown, Yusuke. +3\n",4,6),

                        dialogueText("\nHer love for her son. +3\n"+ "The pain of separation. +3\n"+ "I don't know. +2\n"+
                                "\n"+
                                "You've really changed, Yusuke. +3\n"+ "That's a great idea. +2\n"+ "It won't be easy. +0\n",4,7),

                        dialogueText("\nIt turned out well. +0\n"+ "So you added hope? +0\n"+
                                "\n"+
                                "You provoked Yusuke on purpose? +0\n"+ "Are you scheming something? +0\n"+
                                "\n"+
                                "\"" +"He" + "\""+ "? +0\n"+ "Do you mean Madarame? +0\n"+
                                "\n"+
                                "He was a good man deep down. +3\n"+ "That was another aspect of him. +3\n"+
                                "\n"+
                                "Yeah... +0\n"+ "You're stranger, Yusuke. +0\n"+ "Are you sure about this? +0\n",4,8),

                        //Haru dialogue
                        dialogueText("\nRank 1 Followup:\n"+ "Sounds good. +2\n"+ "That was our deal. +3\n"+ "Thanks. I'm counting on you. +2\n"+
                                "\n"+
                                "You like coffee? +3\n"+ "Are you opening a café? +3\n"+ "Are you starting a farm? +3\n"+
                                "\n"+
                                "What do you mean? +0\n"+ "So you won't accept his offer? +0\n"+ "He sounds suspicious. +3\n"+
                                "\n"+
                                "This is a complex issue. +3\n"+ "You might be wrong. +3\n"+ "Maybe you should fire him. +3\n"+
                                "\n"+
                                "Moonlight Carrot. +3\n"+ "Sun Tomato. +3\n"+ "Jewel Melon. +3\n",5,0),

                        dialogueText("\nA phantom thief wouldn't worry. +2\n"+ "They won't find out. +3\n"+ "It'll be OK, I promise. +3\n"+
                                "\n"+
                                "\"" + "I don't want to go with you." + "\"" + "+3\n"+  "\"" + "I'm afraid of flying." + "\"" + "+0\n"+  "\"" + "We should break up." + "\"" + "+0\n"+
                                "\n"+
                                "I have. +3\n"+ "Not yet. +3\n"+ "Too many times to count. +3\n"+
                                "\n"+
                                "Smart response. +3\n"+ "Sounds like a hassle. +0\n"+ "Which friend? +0\n",5,1),

                        dialogueText("\nThat's pricey. +3\n"+ "What a rip-off. +0\n"+ "It must be amazing. +3\n"+
                                "\n"+
                                "I can't let you do that. +3\n"+ "Let me cover the bill. +3\n"+ "Kthx. +3\n"+
                                "\n"+
                                "You mean... poop!? +3\n"+ "I can taste the elephant. +3\n"+ "Excuse me while I vomit. +3\n"+
                                "\n"+
                                "Hands off my cat. +0\n"+ "I'd rather not think about it. +0\n"+ "Let's ask him. +3\n"+
                                "\n"+
                                "He seemed nice enough. +0\n"+ "He was a little sketchy. +0\n"+ "I'm not really sure. +3\n"+
                                "\n"+
                                "I don't mind. +0\n"+ "It was rather intriguing. +0\n"+ "Let's get coffee again sometime. +3\n",5,2),

                        dialogueText("\nTrust who you want to trust. +0\n"+ "Somebody's telling the truth. +3\n"+ "Trust no one. +3\n"+
                                "\n"+
                                "Are you really considering it? +0\n"+ "You can't give in. +0\n"+ "There has to be another way. +3\n"+
                                "\n"+
                                "That doesn't matter now. +3\n"+ "You didn't have a choice. +0\n"+ "I don't think so. +3\n"+
                                "\n"+
                                "Are you okay? +0\n"+ "We're all here for you. +0\n"+ "Pinch yourself. +3\n",5,3),

                        dialogueText("\nThat's fascinating +3\n"+ "You're so studious. +3\n"+ "Can you make some for me? +3\n"+
                                "\n"+
                                "I had no idea. +3\n"+ "That's a surprise. +0\n"+ "I could've guessed that. +0\n"+
                                "\n"+
                                "You might be right. +0\n"+ "That would be bad. +3\n"+ "Black like coffee? +3\n"+
                                "\n"+
                                "You don't need to apologize. +0\n"+ "That guy is horrible. +0\n"+
                                "\n"+
                                "You're not powerless. +0\n"+ "Be strong, Haru. +3\n"+
                                "\n"+
                                "You can talk to me anytime. +3\n"+ "Let him say what he wants. +3\n"+ "Wanna run away together? +0\n",5,4),

                        dialogueText("\nYou look exhausted. +0\n"+ "Don't overwork yourself. +0\n"+ "Let's go see the nurse. +0\n"+
                                "\n"+
                                "That sounds really tough... +3\n"+ "You should ask some employees. +0\n"+ "What do you want to do? +3\n"+
                                "\n"+
                                "What does Takakura-san think? +3\n"+ "There has to be a way. +3\n"+ "You should tell him that. +3\n"+
                                "\n"+
                                "That's the spirit. +3\n"+ "You can do it, Haru. +3\n"+
                                "\n"+
                                "Don't relax yet. +0\n"+ "I'll always have your back. +3\n"+ "So what's this “magic item”? +0\n",5,5),

                        dialogueText("\nThe soil? +3\n"+ "The planters? +0\n"+ "That beetle over there? +0\n"+
                                "\n"+
                                "It'll help him understand you. +3\n"+ "He's going to love it. +3\n"+ "He might not like it. +3\n"+
                                "\n"+
                                "I'll be cheering for you. +3\n"+ "You're amazing, Haru. +3\n"+ "Are you sure you can do it? +3\n"+
                                "\n"+
                                "You can understand them? +0\n"+ "It's in your nature to nurture. +3\n"+ "I want some too. +3\n",5,6),

                        dialogueText("\nDon't forget to breathe. +0\n"+ "Believe in yourself. +0\n"+ "I'm here for you, Haru. +0\n"+
                                "\n"+
                                "I'm sure you'll do great. +3\n"+ "It'll be fine. +3\n"+ "Give it all you've got, Haru. +3\n"+
                                "\n"+
                                "You're very welcome. +3\n"+ "You did amazing. +3\n"+ "Do I get a reward? +0\n"+
                                "\n"+
                                "He saw us as good friends. +0\n"+ "I like you too, Haru. +0 (ROMANCE)\n"+
                                "\n"+
                                "What're you up to? +0\n"+ "I wanted to hear your voice. +3\n"+ "I miss you. +3\n",5,7),

                        dialogueText("\nWill things be OK? +0\n"+ "That's good to hear. +3\n"+ "You've done great, Haru. +3\n"+
                                "\n"+
                                "I'm sure you'll succeed. +3\n"+ "This won't be easy. +3\n"+ "It all comes down to flavor. +3\n"+
                                "\n"+
                                "If you want. +0\n"+ "Probably not. +0\n"+ "It's hard work, you know. +0\n"+
                                "\n"+
                                "I'm glad too. +3\n"+ "Don't deny yourself. +3\n"+ "Just my teammate? +3\n",5,8),

                        //Kasumi dialogue
                        dialogueText("\nWe're just getting started. +2\n"+ "Go easy on me. +0\n"+ "I'm so done with this. +2\n"+
                                "\n"+
                                "Next time, then. +2\n"+ "You doing okay? +0\n"+ "Lucky for me... +0\n"+
                                "\n"+
                                "I see. +0\n"+ "So now...? +0\n"+
                                "\n"+
                                "No problem. +0\n"+ "You sure? +0\n"+ "Uh, romantically? +0\n"+
                                "\n"+
                                "Leave it to me. +0\n"+ "Let's give it a try. +0\n"+ "Then follow my lead. +0\n"+
                                "\n"+
                                "Impressive. +2\n"+ "Gotta push through it. +0\n"+ "You did eat eventually, right? +0\n",6,0),

                        dialogueText("\nMaking bento? +3\n"+ "Potluck parties? +0\n"+ "“This” being...? +0\n"+
                                "\n"+
                                "I'm touched! +2\n"+ "It looks delicious. +2\n"+ "Let's see if it's good... +0\n"+
                                "\n"+
                                "Is that all for you? +3\n"+ "That seems a little much. +2\n"+ "What IS that? +0\n"+
                                "\n"+
                                "This tastes like... +0\n"+ "It's definitely unique. +2\n"+ "It's... greeeaaat... +0\n"+
                                "\n"+
                                "Not exactly. +0\n"+ "Is there a third option...? +0\n"+
                                "\n"+
                                "Calm down. +0\n"+ "You're going to get it now? +0\n"+
                                "\n"+
                                "This works fine as is. +0\n"+ "I'm enjoying this. +0\n"+ "Let's just eat. +0\n"+
                                "\n"+
                                "You could try again sometime? +3\n"+ "It happens. +3\n"+ "\n"+
                                "\n"+
                                "That sounds right. +0\n"+ "Maybe... +0\n",6,1),

                        dialogueText("\nYou have bad eyesight? +0\n"+ "You're looking to buy? +2\n"+ "I have enough glasses. +0\n"+
                                "\n"+
                                "A pretty modern look. +3\n"+ "Not my style. +0\n"+ "I look so aloof in these. +2\n"+
                                "\n"+
                                "Do they suit your dad, though? +0\n"+ "I'm not so sure... +0\n"+
                                "\n"+
                                "Of course. +2\n"+ "Let's keep going. +2\n"+ "Sure, whatever. +0\n"+
                                "\n"+
                                "Trust your instincts. +0\n"+ "Don't overthink it. +0\n"+
                                "\n"+
                                "Good choice. +2\n"+ "I'm sure he'll love it. +0\n"+
                                "\n"+
                                "It's part of our deal. +0\n"+ "Not a problem at all. +0\n"+ "I expect compensation. +0\n"+
                                "\n"+
                                "Everyone deals with that. +2\n"+ "That's your slump talking. +0\n"+
                                "\n"+
                                "Good luck. +0\n"+ "We'll work at it together. +2\n"+ "No rush, though. +0\n"+
                                "\n"+
                                "I'm glad to hear that. + 2\n"+ "You should  be more confident. +2\n"+ "Of course he is. +0\n",6,2),

                        dialogueText("\nIt's a surprise, yea. +2\n"+ "Not at all. +0\n"+ "What are you scheming? +0\n"+
                                "\n"+
                                "This seems kind of sudden. +0\n"+ "If I'm just watching... +0\n"+
                                "\n"+
                                "It's a good idea. +2\n"+ "Go ahead. I'll watch. +3\n"+ "Maybe stick to gymnastics. +0\n"+
                                "\n"+
                                "Don't give up. +0\n"+ "Just don't lose hope. +0\n"+ "You can beat this, right? +0\n"+
                                "\n"+
                                "Congratulations. +3\n"+ "I saw! +3\n"+ "How's that feel? +2\n"+
                                "\n"+
                                "That's important. +3\n"+ "Don't forget how that feels. +2\n"+
                                "\n"+
                                "Nicely done. +0\n"+ "It's not over yet. +0\n"+
                                "\n"+
                                "Swimming. +3\n"+ "Running. +2\n"+ "Gymnastics. +3\n",6,3),

                        dialogueText("\nIt wasn't on purpose. +0\n"+ "What could you have done? +0\n"+ "At least you realize it now. +0\n"+
                                "\n"+
                                "Don't beat yourself up. +0\n"+ "What'll you do now? +0\n"+ "Calm down. +0\n"+
                                "\n"+
                                "You two were close, then. +0\n"+ "Those must be good memories. +0\n"+ "All for ice cream, huh? +0\n"+
                                "\n"+
                                "... That IS genius. +0\n"+ "How old was she again? +0\n"+
                                "\n"+
                                "She cared about you. +0\n"+ "Sounds like tough training. +0\n"+
                                "\n"+
                                "Why? +0\n"+ "I can imagine. +0\n"+
                                "\n"+
                                "It must have been hard. +0\n"+ "What about Kasumi's feelings? +0\n"+ "Sounds like running away. +0\n"+
                                "\n"+
                                "You have to accept it. +0\n"+ "Try not to think about it. +0\n"+ "So what happens now? +0\n"+
                                "\n"+
                                "I will. +0\n"+ "I can manage that. +0\n"+ "If it's part of the deal. +0\n"+
                                "\n"+
                                "Do you want to run away? +0\n"+ "You have to face it. +3\n"+ "So what if it is? +3\n",6,4),

                        dialogueText("\nMaybe. +0\n"+ "Who Knows? +0\n"+ "Were you frustrated? +0\n"+
                                "\n"+
                                "Is she scary? +0\n"+ "Is she strict? +0\n"+
                                "\n"+
                                "You okay? +3\n"+ "That was a big sigh. +0\n"+ "She's a real taskmaster. +0\n"+
                                "\n"+
                                "That isn't true. +3\n"+ "You need more confidence. +0\n"+ "That's just a mental block. +0\n"+
                                "\n"+
                                "It'll be like a duet. +0\n"+ "You'll become stronger. +0\n"+
                                "\n"+
                                "Of course. +3\n"+ "I could watch you forever. +3\n"+ "Another love confession? +3\n"+
                                "\n"+
                                "I was internally screaming. +0\n"+ "Yeah, it was a breeze. +0\n"+ "I love a good challenge. +3\n",6,5),

                        dialogueText("\nWalk up to Sumire. +3\n"+ "Watch her from a distance. +0\n"+ "Slowly walk away. +0\n"+
                                "\n"+
                                "Look at yourself. +0\n"+ "You're just standing out. +0\n"+
                                "\n"+
                                "Try to stay positive. +3\n"+ "I'm here for you. +3\n"+ "It'll work out. +3\n"+
                                "\n"+
                                "What is it? +0\n"+ "..... +0\n"+
                                "\n"+
                                "You started it. +0\n"+ "What, I can't look at you? +0\n"+
                                "\n"+
                                "It looks great. +3\n"+ "You look really cute. +3\n"+ "I'm in love. +3\n"+
                                "\n"+
                                "Did I help? +0\n"+ "You found your answer? +0\n"+
                                "\n"+
                                "I see... +0\n"+ "So that's how it was. +0\n"+
                                "\n"+
                                "That's how it should be. +3\n"+ "Sounds like progress. +3\n"+
                                "\n"+
                                "The airsoft shop. +0\n"+ "The resale shop. +3\n"+ "Online. +3\n",6,6),

                        dialogueText("\nIt's no problem. +3\n"+ "We'll call it holiday hours. +3\n"+
                                "\n"+
                                "Definitely. +3\n"+ "Of course. +3\n"+
                                "\n"+
                                "Of course I do. +3\n"+ "Vaguely... +0\n"+ "What about it? +0\n"+
                                "\n"+
                                "I know you did. +3\n"+ "You're not worthless. +3\n"+ "This is a new beginning. +3\n"+
                                "\n"+
                                "What's going on? +0\n"+ "There's something else? +0\n"+ "Go ahead. +3\n"+
                                "\n"+
                                "What? +0\n"+ "In luh? +0\n"+
                                "\n"+
                                "Let's stay friends, okay? +0\n"+ "I love you too. +0 (ROMANCE)\n"+
                                "\n"+
                                "Calm down. +3\n"+ "Take your time. +3\n"+
                                "\n"+
                                "So? Any different? +3\n"+ "You are so red right now. +3\n"+ "You're so cute. +3\n"+
                                "\n"+
                                "Get used to it. +3\n"+ "Should I hang up...? +0\n"+ "That's just how it is. +0\n",6,7),

                        dialogueText("\nYou look radiant today. +0\n"+ "Now I'm getting nervous. +0\n"+ "\n"+
                                "\n"+
                                "It's all Sumire. +0\n"+ "Just watch. +0\n"+ "\n"+
                                "\n"+
                                "Calm down. +0\n"+ "Don't rush it. +0\n"+ "\n"+
                                "\n"+
                                "You must be happy. +0\n"+ "I'm so relieved. +0\n"+ "It's only natural, Sumire. +0\n"+
                                "\n"+
                                "And that is...? +3\n"+ "What do you mean? +3\n"+ "Is it someone you love? +3\n"+
                                "\n"+
                                "And there's more to come. +0\n"+ "You were amazing out there. +0\n"+ "\n"+
                                "\n"+
                                "I'll stop if you want. + 0\n"+ "I feel the same way. +0\n"+ "I don't want to let you go. +0\n"+
                                "\n"+
                                "I'm counting on you. +3\n"+ "Don't get ahead of yourself. +3\n"+ "We're our world's champions. +3\n",6,8),

                        //Chihaya dialogue
                        dialogueText("\nI'll be there. +3\n"+ "Such a hassle. +1\n"+ "You're pretty extreme... +1\n"+
                                "\n"+
                                "/=Suggest she gives up./=\n"+ "/=Change her boss's heart./=\n"+ "Encourage her. +0\n"+
                                "\n"+
                                "/=Hrahhh!/=\n"+ "Overturn your fate! +0\n"+ "/=Fight the power!/=\n"+
                                "\n"+
                                "You're so stubborn +0\n"+ "Open your mind to change. +2\n"+
                                "\n"+
                                "Of course I am. +2\n"+ "And if I am? +0\n"+ "Are you stalking me? +0\n",7,0),

                        dialogueText("\n/=Go for the money./=\n"+ "Follow his heart. +0\n"+ "/=Chase a promotion./=\n"+
                                "\n"+
                                "Thieves may steal her away. +0\n"+ "/=Marriage kills individuality./=\n"+ "/=She'll be sad if you break it off./=\n"+
                                "\n"+
                                "I'm not, sorry. +0\n"+ "Who knows...? +0\n",7,1),

                        dialogueText("\nYou're only realizing that now? +0\n"+ "Do you want to test it again? +0\n"+
                                "\n"+
                                "Strengthen your will. +2\n"+ "I don't know. +0\n"+ "Trust in yourself. +3\n"+
                                "\n"+
                                "Tell me more. +0\n"+ "That sounds so peaceful. +0\n"+
                                "\n"+
                                "...The chairman? +0\n"+ "I'm not sure I follow. +0\n"+
                                "\n"+
                                "I think it'll work. +0\n"+ "It all depends on you. +0\n"+
                                "\n"+
                                "I'm glad to hear that. +0\n"+ "I didn't do much. +2\n"+ "Tell me more about your home. +0\n",7,2),

                        dialogueText("\nYou're such a hard worker. +3\n"+ "What about divine power? +0\n"+ "You must have lots of free time. +2\n"+
                                "\n"+
                                "But what? +0\n"+ "Did you spend it all? +0\n"+
                                "\n"+
                                "Who was he? +0\n"+ "Maiden? +0\n"+ "Are you in trouble? +0\n",7,3),

                        dialogueText("\nI like fortune-telling. +0\n"+ "She's really cool. +0\n"+ "I'm doing research for school. +0\n"+
                                "\n"+
                                "...Maiden of Relief? +0\n"+ "This has to be a joke. +0\n"+
                                "\n"+
                                "This guy's sketchy. +0\n"+ "Leave her alone. +0\n"+
                                "\n"+
                                "What's a Maiden of Relief? +0\n"+ "Who thinks you're a monster? +0\n"+ "You're just Chihaya to me. +3\n"+
                                "\n"+
                                "No need to strain yourself. +0\n"+ "Be honest with yourself. +2\n"+ "We'll work on it together. +0\n",7,4),

                        dialogueText("\nYou're not wrong about that. +0\n"+ "You shouldn't have tricked them. +2\n"+ "I don't think so. +3\n"+
                                "\n"+
                                "Are you gonna be okay? +2\n"+ "Be careful. +2\n"+ "So the Maiden's taking action. +0\n",7,5),

                        dialogueText("\nI had no idea. +2\n"+ "I know. +3\n"+
                                "\n"+
                                "I'm glad to hear that. +3\n"+ "That's some good luck. +3\n"+ "It's because you're strong. +3\n"+
                                "\n"+
                                "Why do you ask? +0\n"+ "Hell yeah I am. +3\n"+
                                "\n"+
                                "You give me too much credit. +0\n"+ "It was all your own will. +2\n"+ "I knew it would happen. +0\n",7,6),

                        dialogueText("\nYou really don't understand. +0\n"+ "Listen to what Chihaya's saying. +0\n"+
                                "\n"+
                                "Do you regret what you did? +0\n"+ "Well, fate can be changed. +3\n"+ "That's all in the past now. +2\n"+
                                "\n"+
                                "I like having my fortune read. +0\n"+ "So I can be with you. +0 (ROMANCE)\n"+
                                "\n"+
                                "I wanted to hear your voice too. +2\n"+ "Oh, you didn't mean it...? +0\n"+ "..... +0\n",7,7),

                        dialogueText("\nYou've never been here? +0\n"+ "It wasn't that far away. +0\n"+
                                "\n"+
                                "I support you. +3\n"+ "You have strong convictions. +3\n"+
                                "\n"+
                                "I wonder if you're right... +0\n"+ "So what if I am the Trickster? +0\n"+ "You're pretty sharp. +0\n"+
                                "\n"+
                                "It's not a problem. +0\n"+ "Are you worried about me? +0\n"+ "What does it mean? +0\n"+
                                "\n"+
                                "Thank you.+0\n"+ "That's really reassuring. +0\n"+
                                "\n"+
                                "I don't care about that. +2\n"+ "It's actually pretty cute. +3\n"+
                                "\n"+
                                "I was hoping you'd say that. +0\n"+ "I don't want to go home. +0\n",7,8),
                        //Chihaya 7.5
                        dialogueText("\nHow so? +0\n"+"What have you found? +0\n"+
                                "\n"+
                                "Tell me his name. +0\n"+ "What's Fukurai's first name? +0\n"+
                                "\n"+
                                "I can't tell you. +0\n"+ "Don't worry about it. +0\n",7,9),

                        //Iwai dialogue
                        dialogueText("\nLeave it to me. +1\n"+ "As long as it's safe... +1\n"+ "So what's my first job? +3\n"+
                                "\n"+
                                "Maybe I should call him. +0\n"+ "... Iwai seems sick. +0\n"+
                                "\n"+
                                "Nothing in particular. +0\n"+ "I was daydreaming, sorry. +0\n"+
                                "\n"+
                                "Who was that guy? +0\n"+ "What should I do now? +2\n"+ "How's your cold? +2\n",8,0),

                        dialogueText("\nI know how it feels. +0\n"+ "Is it seriously that hard? +0\n"+
                                "\n"+
                                "I always knew you were a thug. +3\n"+ "Oh. I, uh... have to go. +0\n"+ "Y-Yakuza!? +2\n"+
                                "\n"+
                                "Not really. +0\n"+ "No, I like that stuff. +0\n"+ "We made a deal, didn't we? +3\n"+
                                "\n"+
                                "Is that one of your customers? +0\n"+ "Why are you being so mean? +0\n",8,1),

                        dialogueText("\nIwai. +0\n"+ "I can't tell you. +0\n"+ "It's none of your business. +0\n"+
                                "\n"+
                                "What was that about? +0\n"+ "So that was Tsuda? +0\n"+ "What did he mean," + "\"" + "sell" + "\"" + "him? +0\n"+
                                "\n"+
                                "Hong Kong mafia. +0\n"+ "A 100 million yen deal. +0\n"+
                                "\n"+
                                "Give it your all. +0\n"+ "You two should play nice. +2\n"+ "Where's my reward. +3\n"+
                                "\n"+
                                "I agree. +2\n"+ "Is that a threat? +0\n"+ "What's the issue? +0\n",8,2),

                        dialogueText("\nWhy not? +0\n"+ "You shouldn't lie to your son. +0\n"+
                                "\n"+
                                "You're so kind, Iwai. +0\n"+ "You're pathetic. +3\n"+ "You should call the cops. +0\n"+
                                "\n"+
                                "That's right. +2\n"+ "Don't make assumptions. +0\n"+ "I'll stick around for the guns. +3\n"+
                                "\n"+
                                "You're right. +2\n"+ "Is it really all for Kaoru? +0\n"+ "Well, you got this. +0\n",8,3),

                        dialogueText("\nWhy would he say that? +0\n"+ "No, nothing even close. +0\n"+
                                "\n"+
                                "He definitely does. +0\n"+ "You should ask him. +0\n"+
                                "\n"+
                                "Our futures. +2\n"+ "Girls. +3\n"+ "That's a secret. +3\n"+
                                "\n"+
                                "Right. +2\n"+ "You should tell him, Iwai. +0\n"+ "You should buy us something. +3\n"+
                                "\n"+
                                "He's my age, so it comes easier. +2\n"+ "All I did was listen to him. +2\n"+ "It's part of the job. +0\n",8,4),

                        dialogueText("\nNot at all. +0\n"+ "Absolutely. +3\n"+ "I guess he likes guns? +2\n"+
                                "\n"+
                                "That's horrible. +0\n"+ "He's clever. +3\n"+ "What a crafty bastard. +2\n"+
                                "\n"+
                                "Is Tsuda seriously dangerous? +0\n"+ "Are you going alone? +0\n"+
                                "\n"+
                                "Bring it on. +2\n"+ "I'm worried... +0\n"+ "So what's our first move? +0\n",8,5),

                        dialogueText("\nIt's not impossible. +0\n"+ "I dunno. +2\n"+ "He's matured. +0\n"+
                                "\n"+
                                "I'm back, baby. +2\n"+ "I guess I could consider it. +3\n"+ "If you pay me well. +3\n"+
                                "\n"+
                                "Understood. +2\n"+ "You worry too much. +0\n"+ "Now let's catch him off-guard. +0\n",8,6),

                        dialogueText("\nThat's great news. +2\n"+ "I feel bad for him. +0\n"+ "Are you sure he's alive? +3\n"+
                                "\n"+
                                "Who's Masa? +0\n"+ "Will Karou be OK? +0\n"+
                                "\n"+
                                "We should hurry. +0\n"+ "Let's close up shop. +0\n"+
                                "\n"+
                                "What's your goal here, Masa? +0\n"+ "Cut the bullshit. +0\n"+
                                "\n"+
                                "Tell him the truth. +3\n"+ "You need to trust your son. +3\n"+
                                "\n"+
                                "Karou is really strong-willed. +3\n"+ "He gets that maturity from you. +2\n"+ "He's a cool kid, huh? +3\n"+
                                "\n"+
                                "Like father, like son. +2\n"+ "Gecko bonds go beyond blood. +2\n"+ "Why not newts? +0\n",8,7),

                        dialogueText("\nIt's up to you now, Iwai. +3\n"+ "Kaoru won't lose. +3\n"+ "Iwai's kind of slow. +0\n"+
                                "\n"+
                                "I couldn't leave him. +0\n"+ "It was for the special menu. +0\n"+
                                "\n"+
                                "It's a coincidence. +0\n"+ "Should we close up? +0\n"+ "What if you're right? +2\n",8,8),
                        //Iwai 7.5
                        dialogueText("\nIt most definitely was. +2\n"+ "I did it all for Iwai. +3\n"+ "Actually, it's been fun. +0\n"+
                                "\n"+
                                "I will. +2\n"+ "I want to help you. +2\n"+ "I can't. +0\n"+
                                "\n"+
                                "What's his full name? +0\n"+ "Tell me his name. +0\n",8,9),

                        //Futaba dialogue
                        dialogueText("\nThat wouldn't solve anything. +0\n"+ "That's a great idea. +2\n"+
                                "\n"+
                                "If we work together. +3\n"+ "Want me to help? +2\n"+ "I don't know. +0\n"+
                                "\n"+
                                "Sounds good to me. +0\n"+ "Can you tell me again? Repeat Response\n"+
                                "\n"+
                                "I bet it will. +2\n"+ "I'm not sure. +0\n"+ "Why not ask him directly? +0\n",9,0),

                        dialogueText("\nI what? +0\n"+ "So you're OK? +0\n"+ "I was about to come find you. +3\n"+
                                "\n"+
                                "Good to see you again. +3\n"+ "You're the one who appeared. +2\n"+ "You need to be more careful. +0\n"+
                                "\n"+
                                "It'll only get tougher. +0\n"+ "You will. +0\n"+ "We'll both do our best. +2\n",9,1),

                        dialogueText("\nNope. +2\n"+ "Let's do this together. +3\n"+ "If you want. +0\n"+
                                "\n"+
                                "No, you're talented. +0\n"+ "I bet they were just surprised. +0\n"+
                                "\n"+
                                "Not at all. +2\n"+ "Everyone does it. +2\n"+ "I think it's cute. +3\n"+
                                "\n"+
                                "We'll take it slow. +2\n"+ "You need more training. +0\n"+ "I'll help you anytime. +2\n",9,2),

                        dialogueText("\nHe's in my class. +0\n"+ "Friend might be a bit much. +0\n"+
                                "\n"+
                                "I think you're right. +3\n"+ "No. +0\n"+ "Your... what? +2\n"+
                                "\n"+
                                "What's an NPC? +2\n"+ "Savage. +0\n"+ "He's the protagonist. +3\n"+
                                "\n"+
                                "You did great. +2\n"+ "That's nothing special. +0\n"+ "Ding! Level up! +0\n",9,3),

                        dialogueText("\nWere you happy? +2\n"+ "That must have been a shock. +3\n"+ "How did you react? +0\n"+
                                "\n"+
                                "You didn't know any better. +2\n"+ "Did you apologize to her? +0\n"+ "Sounds like it was her fault. +0\n"+
                                "\n"+
                                "Understood. +0\n"+ "Someone's pushy today. +0\n"+
                                "\n"+
                                "Are you running away again? +2\n"+ "Let's calm down first. +0\n"+ "I'm right here with you. +0\n",9,4),

                        dialogueText("\nWhat horrible parents. +2\n"+ "We have to put a stop to this. +2\n"+ "Strange... how? +0\n"+
                                "\n"+
                                "I'll do it, for you. +3\n"+ "We'll show them the truth. +3\n"+ "Give me some time. +2\n",9,5),

                        dialogueText("\nThat's incredible. +3\n"+ "I'm glad to hear that. +3\n"+ "Did you stutter at all? +2\n"+
                                "\n"+
                                "You worked really hard too. +3\n"+ "You're making me blush... +2\n"+ "Do I get a reward? +0\n"+
                                "\n"+
                                "Fine by me. +0\n"+ "That's all? +0\n"+
                                "\n"+
                                "Congrats. +2\n"+ "You've still got more. +0\n"+ "Want more pats? +2\n",9,6),

                        dialogueText("\nYou've really matured. +3\n"+ "What if you get bullied again? +2\n"+
                                "\n"+
                                "That doesn't sound healthy... +0\n"+ "Are you OK, Futaba? +3\n"+ "You're imagining things. +2\n"+
                                "\n"+
                                "If you want. +2\n"+ "No way. +2\n"+ "You're giving up? +0\n"+
                                "\n"+
                                "Because we're teammates. +0 END\n"+ "Because I love you. +0 (ROMANCE)\n"+
                                "\n"+
                                "I would like that / If that's OK with you. +0\n"+ "Um, Hello? / Is something wrong? +0\n"+ "Earth to Futaba? / Are you still alive? +0\n"+
                                "\n"+
                                "Instant yakisoba. +0\n"+ "Morgana. +0\n"+ "Do I really have to say it? +2\n",9,7),

                        dialogueText("\nWhat are you talking about? +0\n"+ "Don't worry about it. +0\n"+ "...Pardoned? +0\n"+
                                "\n"+
                                "Mission complete. +0\n"+ "Nice job, Futaba. +0\n"+ "You did great. +0\n"+
                                "\n"+
                                "I know. +0\n"+ "I don't mind. +0\n"+ "I like being close. +0\n"+
                                "\n"+
                                "What's wrong. +0\n"+ "Come closer. +0\n"+
                                "\n"+
                                "Take your time. +3\n"+ "You can do this. +3\n"+ "We'll do it together. +3\n"+
                                "\n"+
                                "You can't lose to her. +3\n"+ "Do you want a job too? +2\n"+
                                "\n"+
                                "I honor my promises. +0\n"+ "Just keep it cheap. +0\n"+ "You remember that? +0\n"+
                                "\n"+
                                "I'm counting on you. +0\n"+ "That's a lot of pressure. +0\n"+
                                "\n"+
                                "You already have that right. +3\n"+ "Took you long enough to ask. +3\n"+ "I want that right too. +3\n",9,8),

                        //Sojiro dialogue
                        dialogueText("\nGot it. +3\n"+ "That was our deal. +2\n"+ "It's the least I can do. +2\n"+
                                "\n"+
                                "Making coffee. +2\n"+ "Hitting on girls. +0\n"+ "No idea. +0\n"+
                                "\n"+
                                "Who was he? +0\n"+ "That guy seemed suspicious. +2\n"+ "Who's the" + "\"" + "her" + "\"" + "he mentioned? +0\n"+
                                "\n"+
                                "I want the ladies to love me. +2\n"+ "I don't care about that stuff. +0\n"+
                                "\n"+
                                "Got it. +2\n"+ "Give me a break. +0\n"+ "Why'd you call my cell? +0\n",10,0),

                        dialogueText("\nMedium-fine. +2\n"+ "Coarse. +0\n"+ "Anything goes. +0\n"+
                                "\n"+
                                "Is it a date? +0\n"+ "Is it trouble?? +2\n"+ "You don't want my help anymore? +0\n"+
                                "\n"+
                                "I'm ready to work. +2\n"+ "Go easy on me. +0\n"+ "Thank you in advance. +2\n",10,1),

                        dialogueText("\nTell me more. +3\n"+ "That sounds tough... +0\n"+ "It all tastes the same to me. +0\n"+
                                "\n"+
                                "Run for help +0\n"+ "Call Sojiro's phone +3\n"+ "Kick the man out +0\n"+
                                "\n"+
                                "Understood. +2\n"+ "I'm kind of nervous... +0\n"+ "I'll kick him out. +0\n",10,2),

                        dialogueText("\nIt wasn't bad. +2\n"+ "Nothing special. +0\n"+ "I think I'm addicted! +3\n"+
                                "\n"+
                                "She was like Futaba? +2\n"+ "She wasn't normal, huh? +3\n"+ "So that's why you're a bachelor? +0\n"+
                                "\n"+
                                "It really paid off in the end. +2\n"+ "Almost brings a tear to my eye. +0\n"+ "So much history... +0\n"+
                                "\n"+
                                "Sounds good to me. +0\n"+ "She needs a balanced diet. +2\n"+ "There's always instant noodles. +0\n",10,3),

                        dialogueText("\nI admire it. +0\n"+ "I'm not impressed. +0\n"+ "To each his own. +2\n"+
                                "\n"+
                                "You're wrong. +2\n"+ "I'm sorry. +0\n"+ "Shut your mouth. +3\n"+
                                "\n"+
                                "Saving Futaba was no mistake. +2\n"+ "Just cut your ties with him. +0\n"+
                                "\n"+
                                "Is she okay? +0\n"+ "Try to relax. +0\n"+ "If I can help somehow... +3\n",10,4),

                        dialogueText("\nYou might be right. +3\n"+ "That's not true. +0\n"+ "They're still delicious. +0\n"+
                                "\n"+
                                "Are you alright? +0\n"+ "Have you calmed down? +0\n"+ "Do you want to talk? +0\n"+
                                "\n"+
                                "Let's talk to him. +0\n"+ "You should tell him that. +0\n"+ "You guys are one awkward duo. +0\n"+
                                "\n"+
                                "I'm truly glad. +0\n"+ "You're welcome. +0\n"+ "Feel like a real dad now? +3\n",10,5),

                        dialogueText("\nYou want my suggestion? +2\n"+ "Something with curry. +3\n"+ "I can't decide! +0\n"+
                                "\n"+
                                "I didn't do anything wrong. +0\n"+ "I was just protecting Futaba. +3\n"+ "Sorry. +0\n",10,6),

                        dialogueText("\n	It's great. +3\n"+ "He's a bit of a nag. +3\n"+
                                "\n"+
                                "Are you crying? +0\n"+ "You have a great daughter. +3\n"+ "Congrats. +3\n"+
                                "\n"+
                                "You did great. +3\n"+ "Futaba did great. +3\n"+ "You two were already family. +2\n",10,7),

                        dialogueText("\nFor what? +0\n"+ "You guys are religious? +0\n"+ "I'm not interested. +0\n"+
                                "\n"+
                                "Good for you. +3\n"+ "Thank you. +3\n",10,8),

                        //Akechi dialogue
                        dialogueText("\nYou always seem so busy. +2\n"+ "Do you have no friends? +0\n"+
                                "\n"+
                                "Is that your win? +0\n"+ "Not bad. +0\n"+
                                "\n"+
                                "Shoot very carefully. +2\n"+ "I'll go for a power shot. +2\n"+
                                "\n"+
                                "You used your right hand. +0\n"+ "...Aren't you left-handed? +0\n"+
                                "\n"+
                                "Maybe i'll be a detective. +2\n"+ "No holding back next time. +2\n"+ "I see a lot of things. +3\n"+
                                "\n"+
                                "Sure. +0\n"+ "I'll think about it. +0\n"+ "As rivals? +2\n",11,0),

                        dialogueText("\nGot a sweet tooth, huh? +0\n"+ "Come here often? +0\n"+
                                "\n"+
                                "Should've figured. +3\n"+ "Your life must be so hard. +2\n"+ "I can shoo them away... +0\n"+
                                "\n"+
                                "You've done nothing wrong. +0\n"+ "Why the rush? +0\n"+
                                "\n"+
                                "How about we find out? +0\n"+ "Come here a sec. +0\n"+
                                "\n"+
                                "You looked great. +0\n"+ "It was a necessary evil. +0\n"+ "I should've taken a picture. +0\n"+
                                "\n"+
                                "That was careless, huh? +0\n"+ "Wasn't it fun? +2\n"+ "I can always dress you up again. +0\n",11,1),

                        dialogueText("\nWhat kind of place is this? +0\n"+ "This looks shady... +0\n"+
                                "\n"+
                                "Do they have coffee? +2\n"+ "But I'm underage. +0\n"+ "Now this is my kind of club. +3\n"+
                                "\n"+
                                "Any recommendations? +3\n"+ "Anything's fine by me. +2\n"+ "An ice-cold beer for me. +0\n"+
                                "\n"+
                                "It's a great place. +2\n"+ "I feel a bit nervous. +0\n"+
                                "\n"+
                                "A run-down cafe. +0\n"+ "A shop with great coffee. +0\n"+ "I live there, actually. +0\n"+
                                "\n"+
                                "Pretty frequently. +3\n"+ "I can use a microwave. +3\n"+ "All I need is curry. +2\n"+
                                "\n"+
                                "What are you talking about? +0\n"+ "I kinda get it. +2\n"+ "You really are having fun. +0\n",11,2),

                        dialogueText("\nAll the time. +0\n"+ "I'm not great at them. +0\n"+ "Have you played any? +0\n"+
                                "\n"+
                                "Are you used to gunplay? +2\n"+ "You took that seriously, huh. +0\n"+
                                "\n"+
                                "You wanted to be a hero? +3\n"+ "Very interesting. +2\n"+ "Hard to imagine. +0\n"+
                                "\n"+
                                "Sticking to your justice. +0\n"+ "Doing what people want. +0\n"+ "Neither, really. +0\n"+
                                "\n"+
                                "You did fine. +2\n"+ "You've got a long way to go. +2\n"+ "You were getting cocky. +2\n",11,3),

                        dialogueText(            "\nSo relaxing... +2\n"+ "Seeing you here is weird. +0\n"+ "A while, huh? +3\n"+
                                "\n"+
                                "That was horrible of her. +0\n"+ "... You've been through a lot. +2\n"+
                                "\n"+
                                "This is nothing. +3\n"+ "I'll stay until you're ready. +3\n"+ "Are YOU okay? +2\n"+
                                "\n"+
                                "Same. +\n"+ "I'm just fine. + 0\n"+ "Guess I win. +2\n"+
                                "\n"+
                                "Because we get along. +2\n"+ "Because we're similar. +2\n"+
                                "\n"+
                                "I think you're right. +3\n"+ "I don't know about that. +0\n"+ "Can I put my clothes on? +2\n"+
                                "\n"+
                                "True. +0\n"+ "They'd probably love it. +0\n"+ "My bad, I guess. +2\n",11,4),

                        dialogueText("\nYeah, it's convoluted. +2\n"+ "That's why it's so fun. +3\n"+
                                "\n"+
                                "The psychotic breakdowns. +0\n"+ "What're you getting at? +0\n"+
                                "\n"+
                                "I've made up my mind. +0\n"+ "I won't miss my shot. +0\n"+
                                "\n"+
                                "It's thanks to you. +2\n"+ "I couldn't let myself lose. +3\n"+
                                "\n"+
                                "But we're teammates now. +0\n"+ "Want to join us? +0\n"+
                                "\n"+
                                "I'll think about it. +0\n"+ "I'm not doing that. +0\n"+ "You're my rival. +0\n"+
                                "\n"+
                                "Do I? +0\n"+ "I don't know. +0\n"+ "We're rivals, aren't we? +2\n",11,5),

                        dialogueText("\nWhat'd you want to discuss? +0\n"+ "Why are we in Mementos? +0\n"+
                                "\n"+
                                "I thought you meant in pool. +0\n"+ "You want to fight? +0\n"+ "But why, though? +0\n"+
                                "\n"+
                                "All right. +0\n"+ "Let's do this. +0\n"+
                                "\n"+
                                "Are you satisfied? +0\n"+ "Was that all you got? +0\n"+ "Do you want to keep going? +0\n"+
                                "\n"+
                                "I'd say the same for you. +0\n"+ "The feeling mutual. +0\n"+
                                "\n"+
                                "I definitely wouldn't lose. +3\n"+ "I don't know. +0\n"+ "Probably. +0\n"+
                                "\n"+
                                "Same here. +0\n"+ "Really hate losing, don't you. +3\n"+
                                "\n"+
                                "I accept. +0\n"+ "Let me think about it. +0\n",11,6),

                        dialogueText("\nStory progression for Akechi's rank 9",11,7),

                        dialogueText("\nStory progression for Akechi's rank 10",11,8),

                        //Ann dialogue
                        dialogueText("\nAre you feeling better now? +3\n"+ "She's so strong. +3\n"+ "So are you friends again? +2\n"+
                                "\n"+
                                "You can't blame yourself. + 2\n"+  "You might be right. + 3\n"+
                                "\n"+
                                "It was no big deal. + 2\n"+	"I couldn't just ignore you. + 3\n"+
                                "\n"+
                                "I'll help. + 3\n"+	"Let's find it together. + 3\n"+
                                "\n"+
                                "Of course, You're my teammate. + 2\n"+ "Leave it to me. + 2\n"+ "The no refills thing again ? +2\n",12,0),

                        dialogueText("\nHow's that? +0\n"+ "You're amazing. +0\n"+
                                "\n"+
                                "What kind of stuff...? +0\n"+	"That's your training...? +0\n"+ "I don't get it. +0\n"+
                                "\n"+
                                "You're stupid. +0\n"+ "You're an airhead. +0\n"+ "You're... unique. +0\n"+
                                "\n"+
                                "You're a hard worker. +0\n"+ "That response was annoying. +0\n"+ "Can we stop yet? +0\n"+
                                "\n"+
                                "I like you. +2\n"+ "I love you. +2\n"+ "Can we stop yet? +3\n"+
                                "\n"+
                                "Listen to me. +0\n"+ "This won't help your heart. +0\n"+ "You're a genius... +0\n"+
                                "\n"+
                                "You're right. +0\n"+ "You finally get it. +0\n"+
                                "\n"+
                                "That's odd. +2\n"+ "Has that happened to you? +3\n"+
                                "\n"+
                                "Are you lonely? +0\n"+ "That freedom sounds nice. +2\n"+
                                "\n"+
                                "Could be. +2\n"+ "You're so self-conscious. +0\n"+ "Was she a child model? +0\n",12,1),

                        dialogueText("\nI know what you mean. +3\n"+ "I'm not sure I follow. +0\n"+ "That comes down to you. +2\n"+
                                "\n"+
                                "That was mean of her. +2\n"+ "That's hilarious. +3\n"+ "Was she right? +0\n"+
                                "\n"+
                                "Tell me. +3\n"+ "I'm afraid to know. +2\n"+ "...Who? +0\n"+
                                "\n"+
                                "Good idea. +3\n"+ "How exactly? +2\n"+
                                "\n"+
                                "That's not going to work. +0\n"+ "You haven't learned anything. +0\n"+ "Good luck with that. +3\n"+
                                "\n"+
                                "I train everyday. +2\n"+ "Not really. +0\n"+ "I carry Morgana in my bag. +2\n",12,2),

                        dialogueText("\nMaybe. +0\n"+ "Give it up. +2\n"+
                                "\n"+
                                "You're outmatched. +0\n"+ "She's amazing, huh... +2\n"+
                                "\n"+
                                "It had grace. +2\n"+ "She'd be a great Phantom Thief. +0\n"+
                                "\n"+
                                "So how do you do it? +0\n"+ "Tell me more. +0\n"+
                                "\n"+
                                "I figured that much. +0\n"+ "I mean, that's why it's" + "\"" + "fake" + "\"" + "+0\n",12,3),

                        dialogueText("\nIt seems that way. +3\n"+ "That's such a simple solution. +0\n"+ "If it's a friend, yeah. +2\n"+
                                "\n"+
                                "How so? +0\n"+ "Was she working hard? +0\n"+ "Was she in pain? +0\n"+
                                "\n"+
                                "You're not weak. +0\n"+ "It's because you're kind. +0\n"+
                                "\n"+
                                "Comfort her. +3\n"+ "Listen to what she has to say. +2\n"+ "Show her your own strength. +3\n"+
                                "\n"+
                                "Someone's motivated. +2\n"+ "I'll cheer you on. +2\n"+ "You gonna be okay? +0\n",12,4),

                        dialogueText("\nIt's a trap! +0\n"+ "She admires you. +2\n"+
                                "\n"+
                                "So she could show you up. +0\n"+ "Because you're a natural beauty. +0\n"+
                                "\n"+
                                "Cheer up. +0\n"+ "Please don't cry. +0\n"+
                                "\n"+
                                "You already are one. +0\n"+ "Go get ‘em, tiger. +2\n"+ "What about your action movies...? +0\n"+
                                "\n"+
                                "You got this. +2\n"+ "Don't strain yourself. +0\n"+ "Trying to be like Mika? +0\n",12,5),

                        dialogueText("\nThat's a lot of work... +0\n"+ "You have some real guts. +3\n"+ "You're beautiful as is. +2\n"+
                                "\n"+
                                "There's no doubt in my mind. +3\n"+ "I hope so. +3\n"+ "Good luck finding it. +3\n"+
                                "\n"+
                                "Good advice. +0\n"+ "You're so dumb, ann... +0\n"+
                                "\n"+
                                "She'll be happy to hear that. +3\n"+ "I'm sure she already knows. +3\n"+
                                "\n"+
                                "That's probably it. +2\n"+ "I wonder. +0\n"+ "You can ask her yourself. +2\n",12,6),

                        dialogueText("\nIt's dangerous up here. +0\n"+ "Step away from the ledge. +0\n"+ "Why did you want to come here? +0\n"+
                                "And? +0\n"+ "She's gone, isn't she? +0\n"+
                                "\n"+
                                "Hang in there. +3\n"+ "I believe in you, Ann. +3\n"+
                                "\n"+
                                "You have me. +0 (ROMANCE)\n"+ "You have the others. +0 END\n"+
                                "\n"+
                                "You said " +  "\"" + "I love you. +0\n"+  "\"" + "I didn't hear you. +0\n"+
                                "\n"+
                                "Of course. +2\n"+ "I'm yours forever. +2\n"+ "That's up to you. +0\n",12,7),

                        dialogueText("\nYou really gave it your all. +3\n"+ "You still have a ways to go. +2\n"+ "Everyone was complimenting you. +3\n"+
                                "\n"+
                                "That's so embarrassing. +2\n"+ "I'll be there with you. +3\n"+ "You can do it, Ann. +3\n"+
                                "\n"+
                                "What's wrong? +0\n"+ "It's just the two of us. +0\n"+
                                "\n"+
                                "Of course. +3\n"+ "Anything for you. +3\n"+
                                "\n"+
                                "I will. +0\n"+ "I already am. +0\n"+
                                "\n"+
                                "Of course. +0\n"+ "I should be asking you that. +0\n"+
                                "\n"+
                                "Couples? +0\n"+ "Just Once? +0\n",12,8),

                        //Mishima dialogue
                        dialogueText("\nI don't understand. +0\n"+ "...Phan-Site? +0\n"+
                                "\n"+
                                "You've done good, kid. +3\n"+ "That sounds pretty tough. +0\n"+ "Is this really necessary? +0\n"+
                                "\n"+
                                "Uh, strategic... what? +0\n"+ "Sounds cool. +3\n"+ "You're really hyped for this. +2\n"+
                                "\n"+
                                "Nice hustle, image manager. +2\n"+ "Calm down. +0\n"+ "All-nighters can mess you up. +0\n",13,0),

                        dialogueText("\nI've never heard that before. +0\n"+ "Great idea. +3\n"+ "I'm already taken. +2\n"+
                                "\n"+
                                "I'm worried about this... +0\n"+ "We're part of... The Phandom? +2\n"+ "Let's tell them the truth. +2\n"+
                                "\n"+
                                "It's not your fault. +2\n"+ "Don't overwork yourself. +0\n"+ "I can't trust anyone anymore... +0\n"+
                                "\n"+
                                "Of course. +2\n"+ "Really? +2\n"+ "You'll get it right next time. +2\n",13,1),

                        dialogueText("\nSteak sounds good. +3\n"+ "Some nice organic veggies. +0\n"+ "I love desserts. +2\n"+
                                "\n"+
                                "You're amazing. +2\n"+ "That sounds like a scam. +0\n"+ "Stop this at once. +0\n"+
                                "\n"+
                                "You're right. +0\n"+ "Of course it would. +0\n"+ "Maybe we can keep it. +0\n"+
                                "\n"+
                                "Yup. +2\n"+ "That's one way to view it. +0\n"+ "You'll get better ideas. +2\n",13,2),

                        dialogueText("\nWhy was it so expensive? +2\n"+ "It looks almost real. +0\n"+ "Is it for me? +3\n"+
                                "\n"+
                                "That's a good idea. +2\n"+ "Are you sure that's necessary? +0\n"+ "Don't do anything stupid. +0\n"+
                                "\n"+
                                "All right. +2\n"+ "I expect great things. +0\n"+ "... Did something happen. +0\n",13,3),

                        dialogueText("\nJust tell me already. +2\n"+ "I'm not interested. +0\n"+ "You sure are fired up... +2\n"+
                                "\n"+
                                "Calm yourself. +0\n"+ "Rumors are wrong all the time... +2\n"+ "It's none of your business. +0\n"+
                                "\n"+
                                "Why? +0\n"+ "I didn't ask for that. +0\n"+
                                "\n"+
                                "Is that right...? +0\n"+ "Absolutely. Nice job. +2\n",13,4),

                        dialogueText("\nI don't wanna change his heart. +0\n"+ "Let's cancel the request. +0\n"+
                                "\n"+
                                "Stop worrying about fame. +0\n"+ "You still care about fame? +0\n"+
                                "\n"+
                                "I'm sure there is. +2\n"+ "I hope so. +0\n"+ "Maybe the Phan-Site? +3\n"+
                                "\n"+
                                "Kind of worrying... +2\n"+ "Be careful. +0\n"+ "It's your time to shine. +2\n",13,5),

                        dialogueText("\nI'm not leaving. +3\n"+ "You should run too. +2\n"+ "What are you going to do? +0\n"+
                                "\n"+
                                "You're just gonna take that? +2\n"+ "Believe in yourself. +2\n"+ "They're the real losers. +2\n"+
                                "\n"+
                                "Totally. +2\n"+ "You were super cool. +3\n"+ "Wait, that was all an act? +3\n"+
                                "\n"+
                                "You'll be fine. +2\n"+ "Calm down. +0\n"+ "You've got this, man. +2\n",13,6),

                        dialogueText("You, dead as a doornail. +0\n\n"+ "You showed some real courage. +3\n"+ "I'm glad you're still alive. +2\n"+
                                "\n"+
                                "Something like that. +0\n"+ "Exactly. +0\n"+
                                "\n"+
                                "Don't use our real names. +0\n"+ "This came out of nowhere. +0\n"+ "I can't wait to watch it. +0\n"+
                                "\n"+
                                "Meh. +0\n"+ "What about a parfait instead? +0\n"+ "I'm feeling steak, actually. +0\n"+
                                "\n"+
                                "The sparkle in your eye. +2\n"+ "...+0\n"+ "Your hair? +0\n",13,7),

                        dialogueText("\nDid you find your answer? +0\n"+ "Were you scared stiff? +0\n"+
                                "\n"+
                                "That was courageous. +3\n"+ "But you were afraid. +2\n"+
                                "\n"+
                                "I didn't do anything. +0\n"+ "Nobody stole your heart. +0\n"+ "You changed yourself. +0\n"+
                                "\n"+
                                "I'm sure you will. +0\n"+ "Make it a bestseller. +0\n"+ "You have to write it first. +0\n",13,8),
                        //Mishima 6.5
                        dialogueText("\nAnd what exactly will we win? +2\n"+ "You're so reliable. +3\n"+ "Chill out, dude. +0\n"+
                                "\n"+
                                "Sounds pretty twisted. +2\n"+ "By changing their hearts? +0\n"+ "You really need to chill. +2\n"+
                                "\n"+
                                "Fun...? +0\n"+ "This isn't like you. +0\n"+ "You're worrying me. +0\n"+
                                "\n"+
                                "We very well might. +0\n"+ "Are you feeling guilty? +0\n"+
                                "\n"+
                                "Let's go. +0\n"+ "This is the only way... +0\n"+
                                "\n"+
                                "You're riding our coattails. +0\n"+ "Would that really satisfy you? +0\n"+
                                "\n"+
                                "Do it yourself. +0\n"+ "We're leaving. +0\n"+ "There's no need. +0\n",13,9),

                        //Makoto dialogue
                        dialogueText("\nRank 1 Followup:\n"+ "Let's go again sometime. +2\n"+ "It's a new you. +1\n"+ "The red-light district next +3\n"+
                                "\n"+
                                "You're very well informed. +2\n"+ "Have you ever been here? +0\n"+ "Stay close to me. +0\n"+
                                "\n"+
                                "You should have known better. +2\n"+ "That was dangerous. +3\n"+ "You get flustered easily, huh? +0\n"+
                                "\n"+
                                "Why is it called a salon? +0\n"+ "What kind of place is that? +0\n"+
                                "\n"+
                                "Couldn't agree more. +2\n"+ "He just wouldn't give up. +0\n"+ "Let's actually go in next time. +0\n",14,0),

                        dialogueText("\nYou have the wrong idea. +2\n"+ "So what if we were together? +0\n"+ "It's none of your business. +0\n"+
                                "\n"+
                                "Don't let it get to you. +2\n"+ "You can change. +3\n"+ "Beep boop. +0\n"+
                                "\n"+
                                "Sounds like you two get along. +2\n"+ "Buchimaru-kun? +0\n"+ "Okay, calm down. +0\n",14,1),

                        dialogueText("\nThat's unlike you. +2\n"+ "Is Thieves work distracting you? +0\n"+ "I'm sure you did better than me. +0\n"+
                                "\n"+
                                "Eiko? +0\n"+ "...Who? +0\n"+
                                "\n"+
                                "Don't you have goals? +0\n"+ "What about college? +0\n"+ "What do you mean? +0\n"+
                                "\n"+
                                "Why do you use it? +3\n"+ "That's adorable. +2\n"+ "You're not very ladylike... +0\n"+
                                "\n"+
                                "Do you still want to pursue it? +0\n"+ "I like a woman in uniform. +2\n"+ "It's an amazing goal. +3\n",14,2),

                        dialogueText("\nAre you jealous of them? +0\n"+ "That's annoying. +2\n"+ "He sounds suspicious. +3\n"+
                                "\n"+
                                "I got this. +3\n"+ "Why do I have to do it? +0\n"+ "Only if I can take it seriously. +2\n"+
                                "\n"+
                                "Fist! Of! Justice! +0\n"+ "Report him to the police. +0\n"+ "Try to reach out to her. +2\n",14,3),

                        dialogueText("\nWe just started. +2\n"+ "We're fighting right now. +0\n"+ "Love comes in many forms. +3\n"+
                                "\n"+
                                "Don't be so pushy. +0\n"+ "Back off. +0\n"+ "Here, have my number instead. +0\n"+
                                "\n"+
                                "No, you're being considerate. +0\n"+ "You worry too much. +0\n"+ "Probably a little. +0\n",14,4),

                        dialogueText("\nDo you think he likes you? +0\n"+ "Does Eiko know about this? +0\n"+
                                "\n"+
                                "Probably a little. +0\n"+ "You watch too many soap operas. +0\n"+ "He's definitely suspicious. +0\n"+
                                "\n"+
                                "Who was their leader? +0\n"+ "What gang was it? +0\n"+
                                "\n"+
                                "That's a horrible story. +3\n"+ "Was it tough without him?? +2\n"+ "He was a noble man. +3\n"+
                                "That's admirable. +3\n"+ "I'm sure he was happy. +3\n"+
                                "\n"+
                                "Do you have an answer? +2\n"+ "You can figure that out now. +2\n"+
                                "\n"+
                                "I'm game if you are. +2\n"+ "What are you going to say? +0\n"+ "Refuse her, please. +2\n"+
                                "\n"+
                                "Of course... +2\n"+ "I guess so. +0\n"+ "It's the role I always hoped for. +2\n",14,5),

                        dialogueText("\nHe says that to all his girls. +2\n"+ "That's how he ropes you in. +2\n"+ "I'm not sure. +0\n"+
                                "\n"+
                                "Absolutely. +3\n"+ "What are we going to do? +2\n"+ "Eh, she deserves him. +2\n",14,6),

                        dialogueText("\nGet away from her! +3\n"+ "Your fight's with me. +3\n"+ "I'm calling the cops. +3\n"+
                                "\n"+
                                "We should get out of here. +2\n"+ "Follow me. +2\n"+
                                "\n"+
                                "It looked like it hurt. +0\n"+ "That was the right move. +2\n"+ "You really smacked her. +0\n"+
                                "\n"+
                                "I'm a regular here. +3\n"+ "It's a popular meeting spot. +3\n"+ "Not as much as you. +2\n"+
                                "\n"+
                                "You'll find someone someday. +3 END\n"+ "I'll be your study partner. +0 (ROMANCE)\n"+
                                "\n"+
                                "I do. +3 (ROMANCE)\n"+ "That's not what I meant. +0\n"+
                                "\n"+
                                "I'd do anything for you. +2\n"+ "Were you scared? +0\n"+ "No big deal. +2\n",14,7),

                        dialogueText("\nThat's incredible. +2\n"+ "Your slap worked wonders. +0\n"+ "I'm so relieved. +0\n"+
                                "\n"+
                                "Are you stressing over exams? +2\n"+ "Back to studying? +0\n"+ "For your sister? +0\n"+
                                "\n"+
                                "Police commissioner? +0\n"+ "That sounds difficult. +2\n"+ "Why did you choose that? +0\n"+
                                "\n"+
                                "What an admirable goal. +3\n"+ "That's an amazing dream. +2\n"+ "Your father would be proud.+3\n"+
                                "\n"+
                                "Haha, yea. +0\n"+ "It's not funny at all. +0\n"+ "Just be careful, OK? +2\n"+
                                "\n"+
                                "What's wrong? +0\n"+ "Do you want to study? +0\n",14,8),

                        //Hifumi dialogue
                        dialogueText("\nSure. +1\n"+ "I guess we can. +1\n"+ "Lucky me. +2\n"+
                                "\n"+
                                "That's interesting. +2\n"+ "I like that attitude change. +0\n"+ "It's a bit scary. +0\n"+
                                "\n"+
                                "Have confidence in yourself. +0\n"+ "Don't worry about them. +0\n"+
                                "\n"+
                                "When is it coming out? +0\n"+ "You're, like, an idol. +0\n"+ "But you don't want to, right? +2\n",15,0),

                        dialogueText("\nDescribes you perfectly. +2\n"+ "No, I didn't. +0\n"+ "That's quite the headline. +0\n"+
                                "\n"+
                                "You don't enjoy it? +0\n"+ "Having a difficult time? +2\n"+ "You should just decline. +0\n"+
                                "\n"+
                                "Bring it on. +2\n"+ "Don't worry about it. +0\n"+ "This is part of our deal too. +0\n",15,1),

                        dialogueText("\nI don't mind. +2\n"+ "She has a bad vibe. +0\n"+ "Must've been the katsu curry. +2\n"+
                                "\n"+
                                "They're ridiculous. +0\n"+ "They're cool. +2\n"+ "Never heard of them. +0\n"+
                                "\n"+
                                "I'd love to. +2\n"+ "If our schedules match up. +0\n"+ "Where shall we go next? +2\n",15,2),

                        dialogueText("\nYou're not allowed to date? +0\n"+ "She's scary. +2\n"+ "Accomplish things? +0\n"+
                                "\n"+
                                "You don't like the attention? +0\n"+ "You should stop then. +2\n"+ "Have you told your mother? +0\n"+
                                "\n"+
                                "No worries. +0\n"+ "You've got a lot to deal with... +2\n"+ "Why do you have to apologize? +0\n",15,3),

                        dialogueText("\nYou'll be famous. +0\n"+ "Is that frustrating? +2\n"+ "The media is scary. +0\n"+
                                "\n"+
                                "Do you still like shogi? +2\n"+ "Is that what you want to do? +0\n"+ "Do what you love. +2\n"+
                                "\n"+
                                "You think so? +0\n"+ "You're imagining things. +2\n"+ "Confess your sins, my child. +0\n",15,4),

                        dialogueText("\nThat's almost a relief. +2\n"+ "Don't let your guard down. +0\n"+ "It may come down to luck. +3\n"+
                                "\n"+
                                "Give it your all. +2\n"+ "I believe in you. +3\n"+ "Idols are cool too. +0\n",15,5),

                        dialogueText("\nMaybe... +2\n"+ "You're overthinking it. +0\n"+ "I'm glad her heart changed. +3\n"+
                                "\n"+
                                "Lose what? +0\n"+ "What're you talking about? +0\n"+
                                "\n"+
                                "I support it. +2\n"+ "You should really rethink this. +0\n"+ "It's certainly admirable. +0\n",15,6),

                        dialogueText("\nGive it all you go. +2\n"+ "Do you feel confident? +0\n"+ "You can do it. +0\n"+
                                "\n"+
                                "It was a good effort. +0\n"+ "You'll win next time. +0\n"+ "A very queenly decision. +3\n"+
                                "\n"+
                                "I want to become stronger. +0 END\n"+ "I want to stay by your side. +0 (ROMANCE)\n"+
                                "\n"+
                                "I want us to date. +0 (ROMANCE)\n"+ "We'll be friends forever. +0\n"+
                                "\n"+
                                "Anything for you. +2\n"+ "It was all a big coincidence. +2\n"+ "It was love at first sight. +2\n",15,7),

                        dialogueText("\nThat's rough. +2\n"+ "You'll triumph in the end. +3\n"+ "Just don't lose. +3\n"+
                                "\n"+
                                "You can do it. +0\n"+ "That's reassuring. +0\n"+
                                "\n"+
                                "So you know. +0\n"+ "What do you mean? +0\n"+ "We do. +0\n"+
                                "\n"+
                                "Thank you. +0\n"+ "That's reassuring. +0\n"+
                                "\n"+
                                "What's wrong? +0\n"+ "Are you nervous? +0\n",15,8),
                        //Hifumi 7.5
                        dialogueText(            "\nWhat do you mean? +0\n"+"I don't understand. +0\n"+
                            "\n"+
                            "That won't work. +2\n"+"That's a great strategy. +0\n"+"Do you intend to lose? +0\n"+
                            "\n"+
                            "Let's make her reconsider. +0\n"+"Let's do something about it. +0\n"+
                            "\n"+
                            "What's your mother's name? +0\n"+"Tell me her name. +0\n",15,9),

                        //Yoshida dialogue
                        dialogueText("\nRank 1 Followup:" + "Of course. +1\n"+ "If I must. +0\n"+ "Let me write this down. +3\n"+
                                "\n"+
                                "I want to change the world. +0\n"+ "I want to improve my speech. +2\n"+ "'m not sure... +0\n"+
                                "\n"+
                                "One with conviction. +2\n"+ "A popular one. +0\n"+ "I don't know yet. +2\n"+
                                "\n"+
                                "That was helpful. +2\n"+ "I knew that already. +0\n"+ "What I want to accomplish? +0\n"+
                                "\n"+
                                "It was helpful. +2\n"+ "Somewhat. +0\n"+ "It changed my whole outlook. +2\n",16,0),

                        dialogueText("\nYes, Mr. Yoshida told me. +0\n"+ "No, and I don't care. +0\n"+
                                "\n"+
                                "His message. +2\n"+ "No His speaking skills. +2\n"+ "It's hard to say. +0\n"+
                                "\n"+
                                "I will. +0\n"+ "I'm not sure I get it. +0\n"+ "You think I'll ever find it? +2\n",16,1),

                        dialogueText("\nStop interrupting him. +0\n"+ "You're annoying the audience. +0\n"+ "Just shut up and listen. +0\n"+
                                "\n"+
                                "Yep. +0\n"+ "What do you think? +0\n"+
                                "\n"+
                                "The ex-convict has a point. +0\n"+ "Listen to what he has to say. +0\n"+ "So what if he's No-Good Tora? +0\n"+
                                "\n"+
                                "I couldn't help myself. +2\n"+ "I just spoke the truth. +0\n"+
                                "\n"+
                                "I will. +2\n"+ "I'm not sure I can. +0\n"+ "Can't forget your roots. +2\n",16,2),

                        dialogueText("\nI think so. +2\n"+ "Don't let your guard down. +0\n"+ "The media doesn't matter. +3\n",16,3),

                        dialogueText("\nI'm for them. +2\n"+ "I'm against them. +0\n"+ "I don't really care. +3\n"+
                                "\n"+
                                "I'd decline. +3\n"+ "I'd take the offer. +0\n"+ "I'd leave it to chance. +2\n"+
                                "\n"+
                                "I'll keep this in mind. +2\n"+ "Lose sight of who I am? +0\n"+ "You make quite a case. +2\n",16,4),

                        dialogueText("\nYou should decline. +2\n"+ "That's a sweet deal. +0\n"+ "I wasn't paying attention. +0\n"+
                                "\n"+
                                "He's not No-Good Tora. +0\n"+ "Call him Mr. Yoshida. +0\n"+ "He'll get elected this time. +0\n"+
                                "\n"+
                                "That's not for you to decide. +0\n"+ "Maybe... +0\n"+ "I still believe in him. +0\n",16,5),

                        dialogueText("\nAre you going to do it? +0\n"+ "Don't do it. +0\n"+ "That's a difficult decision. +2\n"+
                                "\n"+
                                "Stick to your beliefs. +3\n"+ "Clear your name. +0\n"+ "Get elected. +0\n"+
                                "\n"+
                                "What good would that do? +0\n"+ "So what if you're right? +0\n"+ "..... +0\n"+
                                "\n"+
                                "I'll never foget that. +2\n"+ "It's tougher than it seems. +2\n"+ "..... +0\n",16,6),

                        dialogueText("\nDo your best. +3\n"+ "Break a leg. +0\n"+ "I'm getting nervous. +2\n"+
                                "\n"+
                                "What are you talking about? +0\n"+ "You had a change of heart. +2\n"+ "..... +0\n",16,7),

                        dialogueText("\nYour true self was revealed. +3\n"+ "You're going to be popular. +2\n"+ "Don't let your guard down. +3\n",16,8),

                        //Kawakami dialogue
                        dialogueText("\nYeah, I get it. +3\n"+ "I will if you will. +2\n"+ "Please stop talking like that. +2\n"+
                                "\n"+
                                "It does. +2\n"+ "I feel nothing. +0\n"+ "I'll tell your boss. +0\n"+
                                "\n"+
                                "I can't say I wasn't... +0\n"+ "Absolutely not! +2\n"+ "What kind of weird things? +0\n"+
                                "\n"+
                                "You need money? +0\n"+ "What's it for? +0\n"+
                                "\n"+
                                "Are you scolding me? +0\n"+ "This is all for you. +0\n"+ "I requested you. +0\n"+
                                "\n"+
                                "You have the wrong number +0\n"+ "Uh, what the hell? +0\n"+ "Is this the hard sell? +2\n",17,0),

                        dialogueText("\nYeah, they do. +2\n"+ "Do some real cooking. +2\n"+ "Can I have a different maid. +0\n"+
                                "\n"+
                                "I was curious. +0\n"+ "So I could slack off in class. +0\n"+ "I wanted to see you. +0\n"+
                                "\n"+
                                "Your sister’s bills, right? +0\n"+ "I’ll request you more often. +3\n"+ "You’re really blunt. +0\n"+
                                "\n"+
                                "You have it rough. +0\n"+ "Are they expensive? +0\n"+ "Don’t overdo it. +0\n"+
                                "\n"+
                                "Thanks. +2\n"+ "I’ll work hard at it. +0\n"+ "You’re not in character. +0\n",17,1),

                        dialogueText("\nThat would be great. +0\n"+ "What are you scheming? +0\n"+
                                "\n"+
                                "How rude. +2\n"+ "No surprise there. +0\n"+ "How old ARE you? +0\n"+
                                "\n"+
                                "Yes, you do. +2\n"+ "You're pushing it. +0\n"+ "You need to love yourself. +3\n"+
                                "\n"+
                                "I already knew that. +0\n"+ "Why did you lie to me? +0\n"+ "You're a bad teacher. +0\n",17,2),

                        dialogueText("\nIt's fun. +2\n"+ "I want to know more. +0\n"+ "Who's the Master here? +2\n"+
                                "\n"+
                                "How Terrible... +2\n"+ "It was inevitable. +0\n"+ "So, did you stop? +2\n"+
                                "\n"+
                                "It's not your fault. +0\n"+ "It was bad luck. +0\n"+ "It's no one's fault. +0\n"+
                                "\n"+
                                "You OK with that? +0\n"+ "Guardians, huh... +0\n"+
                                "\n"+
                                "It's too late now. +0\n"+ "What about our deal? +0\n"+ "I want see you again. +0\n"+
                                "\n"+
                                "Curry is all I eat. +0\n"+ "You get bored of the taste. +0\n"+ "You want some? +2\n",17,3),

                        dialogueText("\nYou just got here. +0\n"+ "Want to rest a bit? +2\n"+ "Give me back my money. +0\n"+
                                "\n"+
                                "Are you all right? +3\n"+ "Have you see a doctor? +2\n"+ "You should go home. +3\n"+
                                "\n"+
                                "Are you OK? +0\n"+ "Don't overdo it. +0\n"+
                                "\n"+
                                "I'll be fine. +0\n"+ "Nah, too lazy. +0\n"+ "How are you feeling, though? +2\n",17,4),

                        dialogueText("\nDon't strain yourself. +2\n"+ "Don't lie. +0\n"+ "Don't pay them. +3\n"+
                                "\n"+
                                "Sister company? +0\n"+ "Can you make a lot there? +0\n"+ "Think this through more. +3\n"+
                                "\n"+
                                "That's the wrong choice. +0\n"+ "Isn't there another way? +0\n"+ "Just rest for now. +0\n",17,5),

                        dialogueText("\nThat's the wrong decision. +0\n"+ "Please reconsider. +0\n"+ "Is this really what you want? +3\n"+
                                "\n"+
                                "You're running away. +2\n"+ "If that's what you decided. +3\n"+ "I need my teacher. +0\n"+
                                "\n"+
                                "Try to remember +0\n"+ "That's your answer. +0\n"+ "Take a look at yourself. +0\n"+
                                "\n"+
                                "Are you going to give up? +0\n"+ "Mistakes can be fixed. +0\n"+
                                "\n"+
                                "Be confident in your answer. +3\n"+ "That's the right choice. +3\n"+ "You're asking a student? +3\n"+
                                "\n"+
                                "I want to protect you. +3\n"+ "That's reassuring. +3\n"+
                                "\n"+
                                "That's reassuring. +3\n"+ "So much for being a maid. +2\n"+ "\n",17,6),

                        dialogueText("\nNonsense. +3\n"+ "You may be right. +0\n"+ "Aren't you old already...? +0\n"+
                                "\n"+
                                "What a bummer. +3\n"+ "Thank you for your service. +3\n"+
                                "\n"+
                                "Not really. +2 END\n"+ "I want to keep seeing you. +2 (ROMANCE)\n"+
                                "\n"+
                                "Got it. +2 END\n"+ "I mean what I say. +0 (ROMANCE)\n"+
                                "\n"+
                                "I'm a master; you're a maid. +0\n"+ "I'm a man; you're a woman. +0 (ROMANCE)\n",17,7),

                        dialogueText("\n...Really? +0\n"+ "I see. +0\n"+ "That's too bad... +0\n"+
                                "\n"+
                                "It doesn't matter. +0\n"+ "That's the best part. +0\n"+
                                "\n"+
                                "We won't get caught. +0\n"+ "Don't worry about it. +0\n"+ "You're so responsible. +0\n"+
                                "\n"+
                                "What are you talking about? +0\n"+ "When did you realize? +0\n"+
                                "\n"+
                                "You got me. +0\n"+ "You have no proof. +0\n"+ "...So what if I am? +0\n"+
                                "\n"+
                                "That sounds promising. +3\n"+ "I'll make sure of it. +3\n"+
                                "\n"+
                                "I want to rely on you. +3\n"+ "I want you to rely on me. +3\n",17,8),
                        //Kawakami 8.5
                        dialogueText("\nWe're talking here. +0\n"+ "You know it, lady. +0\n"+
                                "\n"+
                                "You can't give up. +0\n"+ "But you were so determined. +0\n"+
                                "\n"+
                                "What are their names again? +0\n"+ "I need their names. +0\n",17,9),

                        //Shinya dialogue
                        dialogueText( "\nSure. +1\n"+ "Do we have to? +1\n"+ "Call me when it's game time. +2\n"+
                                "\n"+
                                "Sorry... +2\n"+ "Don't compare me to you. +3\n"+ "Praise would be encouraging. +0\n"+
                                "\n"+
                                "Let's go. +0\n"+ "What a rude employee. +2\n"+ "Something bothering you? +0\n"+
                                "\n"+
                                "Are they strong? +0\n"+ "Do you admire them? +2\n"+
                                "\n"+
                                "So do I. +3\n"+ "They're more than strong. +0\n"+ "I'll let them know. +3\n"+
                                "\n"+
                                "I'll work hard. +2	\n"+ "If I feel like it. +0\n"+ "So then I can beat you? +2\n",18,0),

                        dialogueText("\nDid something happen? +0\n"+ "Let's go eat. +0\n"+ "Are you fasting? +0\n"+
                                "\n"+
                                "OK. +0\n"+ "I'm not down with that. +0\n"+ "Let me think about it. +0\n"+
                                "\n"+
                                "Are they bullying you? +0\n"+ "Sounds like fun? +0\n"+ "You shouldn't waste food. +0\n"+
                                "\n"+
                                "That's the spirit. +2\n"+ "Want to learn martial arts? +0\n"+ "You really love your mom. +0\n"+
                                "\n"+
                                "Sure. +2\n"+ "If our schedules line up. +0\n"+ "Any food requests? +0\n",18,1),

                        dialogueText("\nCalm down. +0\n"+ "You're being a sore loser. +0\n"+ "Yeah, you tell him! +2\n"+
                                "\n"+
                                "Don't get so worked up. +0\n"+ "Get your revenge. +2\n"+ "Pros are amazing, huh? +0\n",18,2),

                        dialogueText("\nIt was pretty weird. +3\n"+ "It happens. +0\n"+ "He must've rigged it. +3\n"+
                                "\n"+
                                "You think you have a chance? +0\n"+ "I'm sure you can do it. +2\n"+ "Don't get so worked up. +0\n"+
                                "\n"+
                                "Are you going to give up? +2\n"+ "You need a new strategy. +3\n"+
                                "\n"+
                                "I'll be cheering you on. +2\n"+ "You're a sharp kid. +0\n"+ "Think you can take him? +2\n",18,3),

                        dialogueText(            "\nI can pay for myself. +0\n"+ "If you insist. +0\n"+ "Do you have enough? +0\n"+
                                "\n"+
                                "You should return the money. +0\n"+ "You're acting like one. +0\n"+
                                "\n"+
                                "That's good. +2\n"+ "I believe in you. +3\n"+
                                "\n"+
                                "A little bit. +0\n"+ "Not at all. +3\n"+ "I'm worried about you. +0\n"+
                                "\n"+
                                "Of course I won't. +2\n"+ "That's up to you. +0\n"+ "I'm your big brother, right? +0\n",18,4),

                        dialogueText(            "\nI haven't done anything. +0\n"+ "Calm down. +0\n"+ "Bad influence? +0\n"+
                                "\n"+
                                "Take it easy on him. +0\n"+ "Think about his feelings. +0\n"+
                                "\n"+
                                "Bring it on, lady. +0\n"+ "I haven't done anything. +0\n"+ "That wouldn't be good. +0\n"+
                                "\n"+
                                "What's your mom's name? +0\n"+ "Tell me about your mom. +0\n",18,5),

                        dialogueText("\nShe's out to control. +0\n"+ "No, she's not. +2\n"+ "Is that what you think? +2\n"+
                                "\n"+
                                "It'll all work out. +2\n"+ "I can't guarantee it. +0\n"+ "Believe in them. +3\n"+
                                "\n"+
                                "Is that too much for you? +0\n"+ "Way to step up. +0\n"+
                                "\n"+
                                "Let's save her. +3\n"+ "That's admirable. +3\n",18,6),

                        dialogueText("\nI'm glad to hear that. +3\n"+ "That's hard to believe. +0\n"+ "Thank the Phantom Thieves. +2\n"+
                                "\n"+
                                "A little bit, yea. +2\n"+ "No, that makes sense. +3\n"+ "It means you've matured. +3\n"+
                                "\n"+
                                "He wants to win at all costs. +2\n"+ "He's too lazy to practice. +0\n"+ "I wouldn't know... +0\n"+
                                "\n"+
                                "Your wish came true. +2\n"+ "You really think It was them? +2\n"+ "You did a great job too. +2\n",18,7),

                        dialogueText("\nThanks to my hard work. +2\n"+ "Thanks to my teacher. +3\n"+
                                "\n"+
                                "You got your revenge. +0\n"+ "You made things right. +3\n"+ "You made new friends. +3\n"+
                                "\n"+
                                "I'll let you in. +0\n"+ "Ask them yourself. +0\n",18,8)
                    )
            )
        }
    }
}